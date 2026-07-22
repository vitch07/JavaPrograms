

import pandas as pd
import numpy as np
import logging
import os
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

logging.basicConfig(
    filename="portfolio.log",
    level=logging.INFO,
    format="%(asctime)s - %(levelname)s - %(message)s"
)



def read_csv(file_path):

    try:

        df = pd.read_csv(file_path)

        logging.info(f"{file_path} loaded successfully")

        return df

    except FileNotFoundError:

        logging.error(f"{file_path} not found")

    except pd.errors.EmptyDataError:

        logging.error(f"{file_path} is empty")

    except pd.errors.ParserError:

        logging.error(f"{file_path} parsing error")

    except Exception as e:

        logging.error(e)

    return None



def load_all_files():

    investors = read_csv("investors.csv")

    funds = read_csv("funds.csv")

    transactions = read_csv("transactions.csv")

    nav_history = read_csv("nav_history.csv")

    return investors, funds, transactions, nav_history


def dataset_information(df, name):

    print("\n","="*50)

    print(name)

    print("="*50)

    print(df.head())

    print("\nShape")

    print(df.shape)

    print("\nColumns")

    print(df.columns.tolist())

    print("\nData Types")

    print(df.dtypes)

    print("\nMissing Values")

    print(df.isnull().sum())

    print("\nStatistics")

    print(df.describe(include="all"))


def display_information(investors,
                        funds,
                        transactions,
                        nav_history):

    dataset_information(investors,"INVESTORS")

    dataset_information(funds,"FUNDS")

    dataset_information(transactions,"TRANSACTIONS")

    dataset_information(nav_history,"NAV HISTORY")



def fill_annual_income(investors):

    median_income = investors["AnnualIncome"].median()

    investors["AnnualIncome"] = investors["AnnualIncome"].fillna(
        median_income
    )

    logging.info("AnnualIncome missing values filled")

    return investors


def fill_expense_ratio(funds):

    mean_expense = funds["ExpenseRatio"].mean()

    funds["ExpenseRatio"] = funds["ExpenseRatio"].fillna(

        mean_expense

    )

    logging.info("ExpenseRatio missing values filled")

    return funds



def fill_risk_profile(investors):

    investors["RiskProfile"] = investors["RiskProfile"].fillna(

        "Moderate"

    )

    logging.info("RiskProfile filled")

    return investors


def fill_nav(nav_history):

    nav_history["NAV"] = nav_history["NAV"].ffill()

    logging.info("NAV forward filled")

    return nav_history


def handle_missing_values(investors,
                          funds,
                          nav_history):

    investors = fill_annual_income(investors)

    investors = fill_risk_profile(investors)

    funds = fill_expense_ratio(funds)

    nav_history = fill_nav(nav_history)

    return investors,funds,nav_history



def remove_duplicate_transactions(transactions):

    before = len(transactions)

    transactions = transactions.drop_duplicates()

    after = len(transactions)

    logging.info(

        f"Duplicates Removed : {before-after}"

    )

    return transactions




def convert_dates(transactions,
                  nav_history):

    transactions["TransactionDate"] = pd.to_datetime(

        transactions["TransactionDate"]

    )

    nav_history["Date"] = pd.to_datetime(

        nav_history["Date"]

    )

    return transactions,nav_history



def remove_nav_outliers(nav_history):

    mean = nav_history["NAV"].mean()

    std = nav_history["NAV"].std()

    lower = mean-(3*std)

    upper = mean+(3*std)

    nav_history = nav_history[

        (nav_history["NAV"]>=lower)&

        (nav_history["NAV"]<=upper)

    ]

    logging.info("NAV Outliers Removed")

    return nav_history



def remove_amount_outliers(transactions):

    threshold = transactions["Amount"].quantile(0.99)

    before = len(transactions)

    transactions = transactions[transactions["Amount"] <= threshold]

    after = len(transactions)

    logging.info(

        f"Amount Outliers Removed (>99th pct): {before-after}"

    )

    return transactions



def latest_nav(nav_history):

    latest = nav_history.sort_values(

        "Date"

    ).groupby("FundID").last()

    latest = latest.reset_index()

    latest = latest[["FundID","NAV"]]

    latest.rename(

        columns={"NAV":"LatestNAV"},

        inplace=True

    )

    return latest

def merge_data(investors,
               funds,
               transactions,
               nav_history):

    latest = latest_nav(nav_history)

    merged = pd.merge(

        transactions,

        investors,

        on="InvestorID",

        how="left"

    )

    merged = pd.merge(

        merged,

        funds,

        on="FundID",

        how="left"

    )

    merged = pd.merge(

        merged,

        latest,

        on="FundID",

        how="left"

    )

    logging.info("Data Merged Successfully")

    return merged

def create_portfolio_value(df):

    df["PortfolioValue"] = (

        df["Units"] *

        df["LatestNAV"]

    )

    return df



def create_profit_loss(df):

    df["ProfitLoss"] = (

        df["PortfolioValue"] -

        df["Amount"]

    )

    return df


def create_return_percentage(df):

    df["ReturnPercentage"] = (

        df["ProfitLoss"]

        /

        df["Amount"]

    )*100

    return df


def create_holding_period(df):

    today = pd.Timestamp.today()

    df["HoldingDays"] = (

        today -

        df["TransactionDate"]

    ).dt.days

    return df


def create_derived_columns(df):

    df = create_portfolio_value(df)

    df = create_profit_loss(df)

    df = create_return_percentage(df)

    df = create_holding_period(df)

    logging.info("Derived Columns Created")

    return df


def preprocess_data():

    investors,funds,transactions,nav_history = load_all_files()

    display_information(

        investors,

        funds,

        transactions,

        nav_history

    )

    investors,funds,nav_history = handle_missing_values(

        investors,

        funds,

        nav_history

    )

    transactions = remove_duplicate_transactions(

        transactions

    )

    transactions,nav_history = convert_dates(

        transactions,

        nav_history

    )

    transactions = remove_amount_outliers(

        transactions

    )

    nav_history = remove_nav_outliers(

        nav_history

    )

    merged = merge_data(

        investors,

        funds,

        transactions,

        nav_history

    )

    merged = create_derived_columns(

        merged

    )

    return merged



# ==========================================================
# NUMPY STATISTICS
# ==========================================================

def compute_fund_returns(nav_history):

    """Return per-fund % return using first vs last NAV in history."""

    ordered = nav_history.sort_values("Date")

    first = ordered.groupby("FundID")["NAV"].first()

    last = ordered.groupby("FundID")["NAV"].last()

    fund_returns = ((last - first) / first) * 100

    fund_returns = fund_returns.reset_index()

    fund_returns.columns = ["FundID", "FundReturn"]

    return fund_returns


def numpy_statistics(investors, transactions, nav_history, merged):

    stats = {}

    stats["MeanInvestmentAmount"] = float(

        np.mean(transactions["Amount"].to_numpy())

    )

    stats["MedianInvestorIncome"] = float(

        np.median(investors["AnnualIncome"].to_numpy())

    )

    stats["StdDevNAV"] = float(

        np.std(nav_history["NAV"].to_numpy())

    )

    fund_returns = compute_fund_returns(nav_history)

    returns_array = fund_returns["FundReturn"].to_numpy()

    stats["FundReturn_90thPercentile"] = float(

        np.percentile(returns_array, 90)

    )

    stats["FundReturn_95thPercentile"] = float(

        np.percentile(returns_array, 95)

    )

    income = merged["AnnualIncome"].to_numpy()

    amount = merged["Amount"].to_numpy()

    correlation = np.corrcoef(income, amount)[0, 1]

    stats["Corr_Income_Investment"] = float(correlation)

    daily_avg_nav = nav_history.groupby("Date")["NAV"].mean()

    stats["AverageDailyNAV"] = float(

        np.mean(daily_avg_nav.to_numpy())

    )

    logging.info("NumPy statistics calculated")

    return stats


# ==========================================================
# PANDAS ANALYSIS
# ==========================================================

def top_investors(merged, n=20):

    grouped = merged.groupby(

        ["InvestorID", "InvestorName"]

    )["PortfolioValue"].sum().reset_index()

    grouped = grouped.sort_values(

        "PortfolioValue", ascending=False

    )

    logging.info(f"Top {n} investors identified")

    return grouped.head(n)


def high_value_investors(merged):

    invest_amount = merged.groupby("InvestorID")["Amount"].sum()

    txn_count = merged.groupby("InvestorID")["TransactionID"].count()

    profile = merged.groupby("InvestorID").agg(

        InvestorName=("InvestorName", "first"),

        RiskProfile=("RiskProfile", "first"),

        AnnualIncome=("AnnualIncome", "first")

    )

    profile["TotalInvestment"] = invest_amount

    profile["TransactionCount"] = txn_count

    profile = profile.reset_index()

    filtered = profile[

        (profile["TotalInvestment"] > 1000000) &

        (profile["RiskProfile"] == "High") &

        (profile["TransactionCount"] > 10) &

        (profile["AnnualIncome"] > 1500000)

    ]

    logging.info("High-value investors identified")

    return filtered


def fund_analysis(merged, nav_history):

    fund_returns = compute_fund_returns(nav_history)

    fund_names = merged[

        ["FundID", "FundName", "Category", "ExpenseRatio"]

    ].drop_duplicates("FundID")

    fund_returns = pd.merge(

        fund_returns, fund_names, on="FundID", how="left"

    )

    aum = merged.groupby("FundID")["PortfolioValue"].sum()

    popularity = merged.groupby("FundID")["TransactionID"].count()

    fund_returns["AUM"] = fund_returns["FundID"].map(aum)

    fund_returns["Transactions"] = fund_returns["FundID"].map(popularity)

    best = fund_returns.loc[fund_returns["FundReturn"].idxmax()]

    worst = fund_returns.loc[fund_returns["FundReturn"].idxmin()]

    highest_expense = fund_returns.loc[fund_returns["ExpenseRatio"].idxmax()]

    highest_aum = fund_returns.loc[fund_returns["AUM"].idxmax()]

    most_popular = fund_returns.loc[fund_returns["Transactions"].idxmax()]

    result = {

        "BestPerformingFund": best["FundName"],

        "WorstPerformingFund": worst["FundName"],

        "HighestExpenseRatioFund": highest_expense["FundName"],

        "HighestAUMFund": highest_aum["FundName"],

        "MostPopularFund": most_popular["FundName"],

    }

    logging.info("Fund analysis completed")

    return result, fund_returns


# ==========================================================
# FINANCE METRICS
# ==========================================================

def finance_metrics(merged):

    metrics = {}

    total_value = merged["PortfolioValue"].sum()

    total_invested = merged["Amount"].sum()

    absolute_return = total_value - total_invested

    metrics["TotalPortfolioValue"] = float(total_value)

    metrics["TotalInvested"] = float(total_invested)

    metrics["AbsoluteReturn"] = float(absolute_return)

    metrics["PortfolioReturnPct"] = float(

        (absolute_return / total_invested) * 100

    )

    avg_holding_days = merged["HoldingDays"].mean()

    years = max(avg_holding_days / 365.0, 1e-9)

    metrics["AverageHoldingPeriodDays"] = float(avg_holding_days)

    metrics["CAGR"] = float(

        ((total_value / total_invested) ** (1 / years) - 1) * 100

    )

    metrics["AnnualizedReturn"] = float(

        (metrics["PortfolioReturnPct"] / years)

    )

    fund_weights = (

        merged.groupby("FundName")["PortfolioValue"].sum() / total_value

    )

    diversification = 1 - float(np.sum(fund_weights.to_numpy() ** 2))

    metrics["DiversificationScore"] = diversification

    avg_expense = merged["ExpenseRatio"].mean()

    metrics["ExpenseRatioImpact"] = float(

        total_value * (avg_expense / 100)

    )

    returns = merged["ReturnPercentage"].to_numpy()

    risk_free = 6.0

    std_returns = np.std(returns)

    if std_returns == 0:

        metrics["SharpeRatio"] = 0.0

    else:

        metrics["SharpeRatio"] = float(

            (np.mean(returns) - risk_free) / std_returns

        )

    category_pct = (

        merged.groupby("Category")["Amount"].sum() / total_invested * 100

    )

    metrics["CategoryWiseInvestmentPct"] = category_pct.round(2).to_dict()

    fund_alloc = (fund_weights * 100).round(2)

    metrics["FundAllocationPct"] = fund_alloc.to_dict()

    logging.info("Finance metrics calculated")

    return metrics


def investor_profit_loss(merged):

    pl = merged.groupby(

        ["InvestorID", "InvestorName"]

    )["ProfitLoss"].sum().reset_index()

    pl = pl.sort_values("ProfitLoss", ascending=False)

    logging.info("Investor-wise profit/loss calculated")

    return pl


# ==========================================================
# OOP : FundPortfolio CLASS
# ==========================================================

class FundPortfolio:

    """Encapsulates a fully merged & cleaned portfolio dataset."""

    def __init__(self, merged, nav_history, investors, transactions):

        self.merged = merged

        self.nav_history = nav_history

        self.investors = investors

        self.transactions = transactions

    def total_portfolio_value(self):

        return float(self.merged["PortfolioValue"].sum())

    def total_invested(self):

        return float(self.merged["Amount"].sum())

    def statistics(self):

        return numpy_statistics(

            self.investors,

            self.transactions,

            self.nav_history,

            self.merged

        )

    def metrics(self):

        return finance_metrics(self.merged)

    def top_investors(self, n=20):

        return top_investors(self.merged, n)

    def high_value_investors(self):

        return high_value_investors(self.merged)

    def fund_analysis(self):

        return fund_analysis(self.merged, self.nav_history)

    def profit_loss(self):

        return investor_profit_loss(self.merged)

    def generate_report(self, path="reports/portfolio_report.txt"):

        os.makedirs(os.path.dirname(path), exist_ok=True)

        stats = self.statistics()

        metrics = self.metrics()

        fund_result, _ = self.fund_analysis()

        with open(path, "w", encoding="utf-8") as f:

            f.write("MUTUAL FUND PORTFOLIO PERFORMANCE REPORT\n")

            f.write("=" * 50 + "\n\n")

            f.write("NUMPY STATISTICS\n")

            f.write("-" * 50 + "\n")

            for k, v in stats.items():

                f.write(f"{k}: {round(v, 4)}\n")

            f.write("\nFINANCE METRICS\n")

            f.write("-" * 50 + "\n")

            for k, v in metrics.items():

                f.write(f"{k}: {v}\n")

            f.write("\nFUND ANALYSIS\n")

            f.write("-" * 50 + "\n")

            for k, v in fund_result.items():

                f.write(f"{k}: {v}\n")

        logging.info(f"Report generated at {path}")

        return path


# ==========================================================
# DATA VISUALIZATION
# ==========================================================

def generate_charts(merged, nav_history, out_dir="charts"):

    os.makedirs(out_dir, exist_ok=True)

    # Portfolio Allocation - Pie Chart (by category)
    category_value = merged.groupby("Category")["PortfolioValue"].sum()

    plt.figure(figsize=(7, 7))

    plt.pie(

        category_value.values,

        labels=category_value.index,

        autopct="%1.1f%%",

        startangle=90

    )

    plt.title("Portfolio Allocation by Category")

    plt.savefig(f"{out_dir}/portfolio_allocation_pie.png")

    plt.close()

    # Fund-wise Investment - Bar Chart
    fund_invest = merged.groupby("FundName")["Amount"].sum().sort_values()

    plt.figure(figsize=(10, 6))

    fund_invest.plot(kind="bar", color="steelblue")

    plt.title("Fund-wise Investment")

    plt.ylabel("Total Invested")

    plt.tight_layout()

    plt.savefig(f"{out_dir}/fund_wise_investment_bar.png")

    plt.close()

    # Monthly Investment Trend - Line Chart
    monthly = merged.copy()

    monthly["Month"] = monthly["TransactionDate"].dt.to_period("M").astype(str)

    monthly_trend = monthly.groupby("Month")["Amount"].sum()

    plt.figure(figsize=(10, 6))

    monthly_trend.plot(kind="line", marker="o", color="green")

    plt.title("Monthly Investment Trend")

    plt.ylabel("Total Invested")

    plt.xticks(rotation=45)

    plt.tight_layout()

    plt.savefig(f"{out_dir}/monthly_investment_trend_line.png")

    plt.close()

    # Category-wise Returns - Bar Chart
    category_returns = merged.groupby("Category")["ReturnPercentage"].mean()

    plt.figure(figsize=(8, 6))

    category_returns.plot(kind="bar", color="orange")

    plt.title("Category-wise Average Returns")

    plt.ylabel("Return %")

    plt.tight_layout()

    plt.savefig(f"{out_dir}/category_wise_returns_bar.png")

    plt.close()

    # NAV Movement - Line Chart (per fund)
    plt.figure(figsize=(11, 6))

    for fund_id, group in nav_history.sort_values("Date").groupby("FundID"):

        plt.plot(group["Date"], group["NAV"], label=fund_id)

    plt.title("NAV Movement Over Time")

    plt.ylabel("NAV")

    plt.legend(fontsize=8)

    plt.tight_layout()

    plt.savefig(f"{out_dir}/nav_movement_line.png")

    plt.close()

    # Top 10 Investors - Horizontal Bar Chart
    top10 = top_investors(merged, 10).sort_values("PortfolioValue")

    plt.figure(figsize=(10, 6))

    plt.barh(top10["InvestorName"], top10["PortfolioValue"], color="purple")

    plt.title("Top 10 Investors by Portfolio Value")

    plt.xlabel("Portfolio Value")

    plt.tight_layout()

    plt.savefig(f"{out_dir}/top10_investors_hbar.png")

    plt.close()

    logging.info("All charts generated")


# ==========================================================
# REPORT EXPORT
# ==========================================================

def export_reports(portfolio, out_dir="reports"):

    os.makedirs(out_dir, exist_ok=True)

    portfolio.top_investors(20).to_csv(

        f"{out_dir}/top_20_investors.csv", index=False

    )

    portfolio.high_value_investors().to_csv(

        f"{out_dir}/high_value_investors.csv", index=False

    )

    portfolio.profit_loss().to_csv(

        f"{out_dir}/investor_profit_loss.csv", index=False

    )

    _, fund_returns = portfolio.fund_analysis()

    fund_returns.to_csv(

        f"{out_dir}/fund_performance.csv", index=False

    )

    portfolio.generate_report(f"{out_dir}/portfolio_report.txt")

    logging.info("All reports exported")


# ==========================================================
# MAIN DASHBOARD
# ==========================================================

def run_dashboard():

    logging.info("Dashboard execution started")

    print("\n" + "=" * 50)

    print("AUTOMATED MUTUAL FUND PERFORMANCE DASHBOARD")

    print("=" * 50)

    merged = preprocess_data()

    # Reload raw reference data for stats that need un-merged frames
    investors, funds, transactions, nav_history = load_all_files()

    investors, funds, nav_history = handle_missing_values(

        investors, funds, nav_history

    )

    transactions = remove_duplicate_transactions(transactions)

    transactions, nav_history = convert_dates(transactions, nav_history)

    portfolio = FundPortfolio(

        merged, nav_history, investors, transactions

    )

    stats = portfolio.statistics()

    print("\nNUMPY STATISTICS")

    for k, v in stats.items():

        print(f"  {k}: {round(v, 4)}")

    metrics = portfolio.metrics()

    print("\nFINANCE METRICS")

    for k, v in metrics.items():

        if isinstance(v, dict):

            print(f"  {k}:")

            for kk, vv in v.items():

                print(f"      {kk}: {vv}")

        else:

            print(f"  {k}: {round(v, 4)}")

    fund_result, _ = portfolio.fund_analysis()

    print("\nFUND ANALYSIS")

    for k, v in fund_result.items():

        print(f"  {k}: {v}")

    print("\nTOP 20 INVESTORS")

    print(portfolio.top_investors(20).to_string(index=False))

    print("\nHIGH-VALUE INVESTORS")

    print(portfolio.high_value_investors().to_string(index=False))

    generate_charts(merged, nav_history)

    export_reports(portfolio)

    print("\nCharts saved to 'charts/' and reports saved to 'reports/'.")

    print("Execution log written to 'portfolio.log'.")

    logging.info("Dashboard execution completed successfully")


if __name__ == "__main__":

    try:

        run_dashboard()

    except Exception as e:

        logging.error(f"Dashboard failed: {e}")

        print(f"Execution failed: {e}")