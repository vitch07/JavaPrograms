package service;

public class WhatsappNotification implements NotificationService {
    @Override
    public void notification() {
        System.out.println("THis is from the whatsapp");
    }
}
