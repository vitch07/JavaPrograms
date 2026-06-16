import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ExpenseManager;
import service.NotificationService;
import service.PaymentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter payment type (credit/debit/upi):");
        String paymentType = scanner.next().toLowerCase();

        System.out.println("Enter notification type (email/whatsapp):");
        String notificationType = scanner.next().toLowerCase();

        PaymentService paymentService = context.getBean(paymentType,PaymentService.class);
        NotificationService notificationService = (NotificationService) context.getBean(notificationType);

        ExpenseManager expenseManager = context.getBean("creditExpenseManager", ExpenseManager.class);
        expenseManager.Gas_bill(1000.00);


    }
}
