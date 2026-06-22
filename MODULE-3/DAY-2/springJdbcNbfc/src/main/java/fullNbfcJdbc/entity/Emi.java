package fullNbfcJdbc.entity;

import java.util.Date;

public class Emi {
    private int emiId;
    private int loanId;
    private Date dueDate;
    private double amount;
    private boolean paid;

    public Emi(
            int emiId,
            int loanId,
            Date dueDate,
            double amount,
            boolean paid){

        this.emiId = emiId;
        this.loanId = loanId;
        this.dueDate = dueDate;
        this.amount = amount;
        this.paid = paid;
    }

    public int getEmiId() {
        return emiId;
    }

    public void setEmiId(int emiId) {
        this.emiId = emiId;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public String toString(){
        return "EMi_id: " + emiId + "loan_id: " + loanId + "DueDate: " + dueDate +
                "Amount" + amount + "paid" + paid;
    }

}
