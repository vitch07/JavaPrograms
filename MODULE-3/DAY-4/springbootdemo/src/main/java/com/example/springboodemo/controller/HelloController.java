package com.example.springboodemo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Scanner;

@RestController

public class HelloController {

    @RequestMapping("/hi")
    public String sayHi(){
        return "Welcome to the first rest api controller UI using spring boot";
    }

    @RequestMapping("/bi")
    public String bye(){
        return "Bye see you next time........";
    }

    @RequestMapping("/showdate")
    public Date numbers(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return Date.valueOf(s);
    }
}
