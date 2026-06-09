package Encapsulation;

import java.util.Scanner;
class Debite extends Payment {
    @Override
    public void checkAmount(){
        System.out.println("THe amount remaining in the debit card ");
    }
    public void pay(){
        System.out.println("It is being payed using Debit");
    }

}

public class Debit {
    public static void main(String[] args){
        Payment pay;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to choose the choice 1:UPI 2:Debit ");
        int num = sc.nextInt();
        sc.nextLine();
        switch(num){
            case 1:
                pay = new UPI();
                break;
            case 2:
                pay = new Debite();
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }
        pay.checkAmount();

    }
}