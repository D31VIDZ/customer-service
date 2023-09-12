package com.example.customersservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customersservice.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
