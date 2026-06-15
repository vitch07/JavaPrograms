package doaNBFC;

import entity.Repayment;

import java.util.List;

public interface RepaymentDao {
    void save(Repayment repayment);
    List<Repayment> findByLoan(int loanId);
    int calculateOverdueDays(int loanId);
    String classifyLoanStatus(int loanId);

}
