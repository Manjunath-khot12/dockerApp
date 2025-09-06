package com.example.demo11.repository;


import com.example.demo11.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<customer,Long> {
}
