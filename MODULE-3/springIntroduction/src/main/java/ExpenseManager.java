public class ExpenseManager {
    NotificationService notificationService;
    PaymentService paymentService;
    ExpenseManager(PaymentService paymentService,NotificationService notificationService){
        this.notificationService = notificationService;
        this.paymentService = paymentService;
    }

    public void Gas_bill(double amount){
            paymentService.pay();
            notificationService.notification();
    }
}
