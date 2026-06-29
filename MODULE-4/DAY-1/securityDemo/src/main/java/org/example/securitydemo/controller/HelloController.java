package org.example.securitydemo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hellonormal(){
        return "Hello to all !!!!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public String hello() {
        return "Hello, World! to User";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloadmin() {
        return "Hello, Admin!";
    }

    @GetMapping("/officer")
    public String helloofficer() {
        return "Hello, Officer!";
    }
}
