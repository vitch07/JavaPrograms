package org.example.jwtdemo.service;

import jakarta.annotation.PostConstruct;
import org.example.jwtdemo.Repo.JpaUserRepo;
import org.example.jwtdemo.model.JpaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private JpaUserRepo jpaUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) {
        // Implement your logic to load user details from the database or any other source

        JpaUser jpanewuser = jpaUserRepo.findByUsername(username);
        return User.builder()
                .username(jpanewuser.getUsername())
                .password(jpanewuser.getPassword())
                .roles(jpanewuser.getRoles()) // You can set roles based on your requirements
                .build();
    }

    









//    @PostConstruct
//    public void init(){
//        JpaUser user1 = new JpaUser();
//        user1.setUsername("user");
//        user1.setPassword(passwordEncoder.encode("user"));
//        user1.setRoles("user");
//
//        JpaUser user2 = new JpaUser();
//        user2.setUsername("admin");
//        user2.setPassword(passwordEncoder.encode("admin"));
//        user2.setRoles("admin");
//
//        jpaUserRepo.save(user1);
//        jpaUserRepo.save(user2);
//
//    }
}

