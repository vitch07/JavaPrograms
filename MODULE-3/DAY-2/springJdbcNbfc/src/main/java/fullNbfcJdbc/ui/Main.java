package fullNbfcJdbc.ui;

import fullNbfcJdbc.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    EmiConsoleController emiconsole = context.getBean(EmiConsoleController.class);
    emiconsole.welcomeMessage();
    emiconsole.show();
}
}
