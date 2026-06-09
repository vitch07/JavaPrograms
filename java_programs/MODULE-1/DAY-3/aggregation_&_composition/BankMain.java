package demo;
import java.util.Scanner;
public class BankMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details to create a bank account " +
                "1: account_number 2: initial balance");
        int account_number = sc.nextInt();
        sc.nextLine();
        double bal = sc.nextDouble();

        Bank bnk  = new Bank(account_number,bal);
        do{
        System.out.println("1: deposit , 2: withdraw , 3: check_balance");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("enter the number to deposit: ");
                double n = sc.nextDouble();
                bnk.deposit(n);
                break;
            case 2:
                System.out.println("enter the number to withdraw: ");
                int n1 = sc.nextInt();
                bnk.withdraw(n1);
                break;
            case 3:
                double balanc = bnk.getBalance();
                System.out.println("the balance is " + balanc);
                break;
            default:
                System.out.println("entered wrong choice");
                return;
        }
    } while(true);
    }
}
