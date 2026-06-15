package entity;

import java.util.Date;

public class Repayment {

    private int loanId;
    private double amountPaid;
    private Date dueDate;
    private Date paidDate;

    public Repayment(int loanId, double amountPaid, Date dueDate, Date paidDate) {
        this.loanId = loanId;
        this.amountPaid = amountPaid;
        this.dueDate = dueDate;
        this.paidDate = paidDate;
    }

    public int getLoanId() { return loanId; }
    public double getAmountPaid() { return amountPaid; }
    public Date getDueDate() { return dueDate; }
    public Date getPaidDate() { return paidDate; }
}


