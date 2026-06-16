package payment;

public class DebitCard implements  PaymentService{

    public void pay(double amount)
    {
        System.out.println("paid using debitcard..");
    }

}
