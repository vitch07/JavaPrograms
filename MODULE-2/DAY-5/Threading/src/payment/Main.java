package payment;

import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Debit , 2: Credit , 3: UPI ");
        int num = sc.nextByte();
        ExpenseManager exp;

        switch (num) {
            case 1:
//                 exp = new ExpenseManager(new DebitCard());
                exp.payElectricityBill(40000);
                exp.payGasBill(50000);

            case 2:
                 exp = new ExpenseManager(new UPI());


            case 3:
                exp = new ExpenseManager(new CreditCard())







        }


    }
}
