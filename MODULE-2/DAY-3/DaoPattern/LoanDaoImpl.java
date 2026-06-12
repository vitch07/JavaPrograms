package DaoPattern;

import entity.Loan.Loan;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LoanDaoImpl implements LoanDao{
    private ArrayList<Loan> loans = new ArrayList<>();
    @Override
    public void save(Loan l) {
        loans.add(l);
    }

    public ArrayList<Loan> findAll() {
        return loans;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public void remove(int loanid) {

    }


    @Override
    public Iterable<Loan> findByStatus(String status) {
        return null;
    }

    @Override
    public Iterable<Loan> findByType(String type) {
        return null;
    }

    @Override
    public void updateInterest(String name,int rate) {
        loans.stream()
                .filter(new Predicate<Loan>() {
                    @Override
                    public boolean test(Loan loan) {
                        return loan.getLoanType().equalsIgnoreCase(name);
                    }
                })
                .map(new UnaryOperator<Loan>(){
                    @Override
                    public Loan apply(Loan loan) {
                        loan.setInterest(loan.getInterest() + 2);
                        return loan;
                    }
                });
    }


    @Override
    public Iterable<Loan> updateLoanInterest(int rate) {
        return null;
    }

}
