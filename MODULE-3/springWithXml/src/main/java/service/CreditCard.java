package service;

public class CreditCard implements PaymentService {
    public void pay(){
        System.out.println("Paying using Credit Card");
    }
}
