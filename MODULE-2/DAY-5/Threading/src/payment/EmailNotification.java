package payment;

public class EmailNotification implements NotificationService{
    @Override
    public void getNotificationService(String notificationType) {
        System.out.println("We received Notification from Email..");
    }
}
