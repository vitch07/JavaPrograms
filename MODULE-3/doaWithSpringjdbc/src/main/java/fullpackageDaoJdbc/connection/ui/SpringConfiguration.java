package fullpackageDaoJdbc.connection.ui;


import fullpackageDaoJdbc.connection.connection.DBManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import fullpackageDaoJdbc.connection.dao.TodoDao;
import fullpackageDaoJdbc.connection.dao.ToDoaImplCollections;

import java.util.Scanner;

@Configuration
public  class SpringConfiguration {

    @Bean
    public DBManager dbManager(){
        return new DBManager();
    }
    @Bean
    public TodoDao todoDoa(){
        return new ToDoaImplCollections(dbManager());
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
