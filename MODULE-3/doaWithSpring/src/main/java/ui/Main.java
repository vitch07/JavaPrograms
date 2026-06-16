package ui;

import doa.ToDoaImplCollections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        TodoConsoleController todoConsoleController = context.getBean(TodoConsoleController.class);

        todoConsoleController.welcomeMessage();
        todoConsoleController.showMenu();
    }
}
