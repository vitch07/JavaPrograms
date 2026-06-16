package ui;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import doa.TodoDao;
import doa.ToDoaImplCollections;

import java.util.Scanner;

@Configuration
public  class SpringConfiguration {

    @Bean
    public TodoDao todoDoa(){
        return new ToDoaImplCollections();
    }
    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
    @Bean
    public TodoConsoleController todoConsoleController(Scanner scanner,TodoDao todoDao){
        return new TodoConsoleController(scanner,todoDao);
    }
}
