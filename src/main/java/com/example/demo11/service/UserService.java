package com.example.demo11.service;


import com.example.demo11.entity.customer;
import com.example.demo11.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @PostConstruct
    public  void init()
    {
        customer u1=new customer(1,"manju",23);
        customer u2=new customer(2,"anju",23);
        customer u3=new customer(3,"naju",23);
        List<customer> list=new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        userRepo.saveAll(list);
    }

    public List<customer> getAllCustomers(){
        return  userRepo.findAll();
    }

}
