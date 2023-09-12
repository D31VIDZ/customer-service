package com.example.customersservice.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customersservice.dots.CustomerDTO;
import com.example.customersservice.entities.Customer;
import com.example.customersservice.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAll(){
		List<Customer> custos = service.getAll();
		
		return ResponseEntity.ok(custos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> getById(@PathVariable Long id) throws Exception{
		Optional<Customer> custo = service.getCustomerById(id);
		if(custo.isPresent()) {
		return ResponseEntity.ok(custo);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void postCustomer(@Valid CustomerDTO custo) {
		service.createCustomer(custo);
	}
	
	@DeleteMapping
	public void DeleteCustomer(Long id) {
		service.deleteCustomerbyId(id);
	}
	
}
