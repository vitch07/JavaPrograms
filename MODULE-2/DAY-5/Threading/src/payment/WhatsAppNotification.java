package payment;

public class WhatsAppNotification implements NotificationService{
    @Override
    public void getNotificationService(String notificationType) {
        System.out.println("We received Notification from the Whatsapp");
    }
}
