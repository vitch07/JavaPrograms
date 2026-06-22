package springFlightPackage.ui;

import springFlightPackage.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);
        MyConsoleController myConsoleController = context.getBean(MyConsoleController.class);
        try {
            myConsoleController.Menu();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
