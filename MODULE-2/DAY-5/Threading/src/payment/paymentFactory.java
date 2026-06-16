package payment;

public class paymentFactory {
   public static CreditCard credit = new CreditCard();
   private static DebitCard debi = new DebitCard();
    private static UPI upi=new UPI();
    private static EmailNotification emailNotification = new EmailNotification();
    private static WhatsAppNotification whatsAppNotification = new WhatsAppNotification();
    public static PaymentService getPaymentService(String paymentType){
        if(paymentType.equalsIgnoreCase("credit")){
            return credit;
        }else if(paymentType.equalsIgnoreCase("debit")){
            return debi;
        }else if(paymentType.equalsIgnoreCase("upi")){
            return upi;
        }
        return null;
    }
    public static NotificationService getNotificationService(String notificationType){
        if(notificationType.equalsIgnoreCase("email")){
            return emailNotification;
        }else if(notificationType.equalsIgnoreCase("whatsapp")){
            return whatsAppNotification;
        }
        return null;
    }
}


















}
