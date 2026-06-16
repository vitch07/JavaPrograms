package payment;

public class CreditCard implements PaymentService{
    CreditCard(){}
    @Override
    public void pay(double amount) {
        System.out.println("Paid using  Credit card"  );
    }
}
