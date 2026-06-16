import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MySpringConfiguration {
    @Bean("Credit")
    public PaymentService CreditCardService(){
        return new CreditCard();
    }
    @Bean("Debit")
    public PaymentService DebitCardService(){
        return new DebitCard();
    }
    @Bean("Email")
    public NotificationService Emailnotification(){
        return new EmailNotification();
    }
    @Bean("Whatsapp")
    public NotificationService Whatsappnotification(){
        return new WhatsappNotification();
    }
    @Bean
    public ExpenseManager expenseManager(@Qualifier("Debit") PaymentService paymentService,@Qualifier("Email") NotificationService notificationService){
        return new ExpenseManager(paymentService,notificationService);
}}
