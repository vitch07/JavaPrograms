package org.example.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableMethodSecurity
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @Bean
    public InMemoryUserDetailsManager userDetails(){
        UserDetails user1 = User.builder()
                .username("user1")
                .password("12344")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("1223")
                .roles("ADMIN").build();
        UserDetails officer = User.builder()
                .username("officer")
                .password("1234")
                .roles("OFFICERS")
                .build();
        return new InMemoryUserDetailsManager(user1, admin, officer);
    }
//    @Bean
////    public PasswordEncoder passwordEncoder1(){
////        return new BCryptPasswordEncoder();
////    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/hello").permitAll()
                .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .build();
    }

}
