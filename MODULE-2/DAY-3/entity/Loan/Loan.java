package entity.Loan;

public class Loan {
    private int loanId;
    private String loanType;
    private int amount;
    private int tenure;
    private int interest;
    private String status;

    public Loan(int loanId, String loanType, int amount, int tenure, int interest, String status) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.amount = amount;
        this.tenure = tenure;
        this.interest = interest;
        this.status = status;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return "Loan details " + loanId + " " + loanType + " " + amount + " " + tenure + " " + interest;
    }

}

