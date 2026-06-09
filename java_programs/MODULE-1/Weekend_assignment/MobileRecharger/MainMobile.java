package MobileRecharger;
import java.util.Scanner;

public class MainMobile {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Mobile Number: ");
            String mobile = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            MobileRecharge user = new MobileRecharge(mobile, balance);
            while (true) {

                System.out.println("1. Recharge");
                System.out.println("2. Make Call");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");

                System.out.print("Choose Option: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter Recharge Amount: ");
                        double rechargeAmount = sc.nextDouble();
                        user.recharge(rechargeAmount);
                        break;
                    case 2:
                        System.out.print("Enter Call Charge: ");
                        double charge = sc.nextDouble();
                        user.makeCall(charge);
                        break;
                    case 3:
                        System.out.println("Current Balance: " + user.getBalance());
                        break;

                    case 4:
                        System.out.println("Thank You!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Option");
                }
            }
        }

}
