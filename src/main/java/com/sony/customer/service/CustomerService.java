package com.sony.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.customer.entity.Customer;
import com.sony.customer.repository.CustomerRepository;

@Service

public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}

	public Customer getCustomerById(String id) {
			Optional<Customer> op = repo.findById(id);
			
		return (op.isEmpty())?null:op.get();
	}

	public Customer addNewCustomer(Customer c) {
		Customer op = repo.save(c);
		return op;
	}

	public Customer updateCustomer(String id, Customer c) {
		c.setId(id);
		Customer op = repo.save(c);
		return op;
	}
	
	
}
