package payment;

import java.util.Scanner;

public class MainPayment {
    public static void main(String[] args) {
        //constructor injection
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter payment type: credit/debit/upi");
        String paymentType=scanner.next();
        System.out.println("Enter notification type: email/whatsapp");
        String notificationType=scanner.next();
        PaymentService paymentService= paymentFactory.getPaymentService(paymentType);
        NotificationService notificationService=paymentFactory.getNotificationService(notificationType);
        ExpenseManager expenseManager=new ExpenseManager(paymentService);
        expenseManager.payElectricityBill(1000);
        expenseManager.payWaterBill(200);
        expenseManager.payGasBill(100);
    }
}
