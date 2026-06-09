package MobileRecharger;


public class MobileRecharge {

    private String mobileNumber;
    private double balance;

    MobileRecharge(String mobileNumber, double balance) {
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    public void recharge(double amount) {
        balance += amount;
        System.out.println("Recharge successful: " + amount);
    }

    public void makeCall(double charge) {

        if (balance >= charge) {
            balance -= charge;
            System.out.println("Call completed.");
            System.out.println("Charge deducted: " + charge);
        } else {
            System.out.println("Low Balance.....Please recharge.");
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Mobile Number: " + mobileNumber +
                "Balance: ₹" + balance;
    }
}
