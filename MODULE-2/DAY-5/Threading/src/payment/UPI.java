package payment;

public class UPI implements PaymentService{

    UPI(){}
    @Override
    public void pay(double amount) {
        System.out.println("Paid using  UPI"  );
    }
}
