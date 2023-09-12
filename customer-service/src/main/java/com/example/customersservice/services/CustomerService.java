package com.example.customersservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customersservice.dots.CustomerDTO;
import com.example.customersservice.entities.Customer;
import com.example.customersservice.repositories.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	public List<Customer> getAll(){
		return repository.findAll();
	}
	
	public Optional<Customer> getCustomerById(Long customerId) throws Exception {
		Optional<Customer> custome = repository.findById(customerId);
		if(custome == null) {
			throw new Exception("prato não encontrado!");
		}else {
		return custome;
		}
	}
	
	public void createCustomer(CustomerDTO custo) {
		Customer custome = new Customer(custo);
		this.addCustomer(custome);
	}
	
	public void addCustomer(Customer custo) {
		repository.save(custo);
	}
	
	public void deleteCustomerbyId(Long id) {
		repository.deleteById(id);
	}
}