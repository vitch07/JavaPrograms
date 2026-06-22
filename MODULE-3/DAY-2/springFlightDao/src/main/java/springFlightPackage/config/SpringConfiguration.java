package springFlightPackage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "springFlightPackage")
public class SpringConfiguration {
    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

}

