package demo;

public class Bank {
    private int account_no;
    private double account_balance = 0;
    Bank(){}

    Bank(int account_no,double account_balance){
        this.account_no = account_no;
        this.account_balance = account_balance;
    }
    public void setAccount_no(int account_no){
        this.account_no = account_no;
    }
    public int getAccount_no(){
        return this.account_no;
    }
    public void setInitialBalance(int cash) {
        this.account_balance  = cash;
    }
    public void deposit(double number){
        this.account_balance += number;
    }

    public void withdraw(int number) {
        if ((account_balance - number) < 0) {
            System.out.println("you are not having this much amount left in account " +
                    " available balance" + account_balance);

        } else {
            account_balance -= number;
            System.out.println("The windrawn cash is " + number + "available balance "
                    + account_balance);
        }
    }


    public double getBalance(){
        return this.account_balance;
    }
}
