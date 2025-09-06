package com.example.demo11.controller;

import com.example.demo11.entity.customer;
import com.example.demo11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class WelcomeController {

    @Autowired
    UserService us;

    @GetMapping("/manju")
    public List<customer> welcome(){
         return us.getAllCustomers();
    }

    @GetMapping
    public String welcomes(){
        return "hello";
    }
}
