package DaoPattern;

import entity.Loan.Loan;

import java.util.ArrayList;
import java.util.Collection;

public interface LoanDao {
        public void save(Loan l);
        public void remove(int loanid);
        public Collection<Loan> findAll();
        public Iterable<Loan> findByStatus(String status);
        public Iterable<Loan> findByType(String type);
        public void updateInterest(String name,int rate);
        public Iterable<Loan> updateLoanInterest(int rate);

    }

