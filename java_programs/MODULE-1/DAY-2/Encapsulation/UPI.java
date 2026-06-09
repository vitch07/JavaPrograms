package Encapsulation;

public class UPI extends Payment {
    @Override
    public void pay(){
        System.out.println("The payment is done using UPI ");
    }
    @Override
    public void checkAmount(){
        System.out.println("THe amount remaining in the UPI is ");
    }
}
