package fullNbfcJdbc.config;

import fullNbfcJdbc.EmiDao.EmiDao;
import fullNbfcJdbc.EmiDao.EmiDaoImpl;
import fullNbfcJdbc.connection.DBmanager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan (basePackages = "fullNbfcJdbc")
public class SpringConfiguration {
//    @Bean
//    public DBmanager dbManager() {
//        return new DBmanager();
//    }
//    @Bean
//    public EmiDao emiDao(DBmanager dbManager){
//        return new EmiDaoImpl(dbManager);
//        }
    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
    }

