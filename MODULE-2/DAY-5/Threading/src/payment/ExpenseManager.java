package payment;

public class ExpenseManager  {
    private PaymentService paymentservice;
    ExpenseManager(PaymentService paymentservice){
        this.paymentservice = paymentservice;
    }
    public void payElectricityBill(double amount){
        System.out.println("Paying electricity bill of " + amount);
        paymentservice.pay(amount);
        System.out.println("electricity bill paid..");
    }
    public void  payGasBill(double amount){
        System.out.println("Paying gas bill"+amount);
        paymentservice.pay(amount);
        System.out.println("gas bill is done");
    }
    public  void payWaterBill (double amount){
        System.out.println("Paying water bill of "+amount);
        paymentservice.pay(amount);
        System.out.println("Water bill paid");
    }

}
