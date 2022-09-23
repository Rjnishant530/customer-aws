package com.sony.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sony.customer.entity.Customer;
import com.sony.customer.entity.CustomerError;
import com.sony.customer.entity.CustomerList;
import com.sony.customer.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public CustomerList handleGetAllCustomers(){
		return new CustomerList(service.getAllCustomer());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> handleGetCustomerById(@PathVariable String id){
		Customer c = service.getCustomerById(id);
		
		return (c==null)?ResponseEntity.status(404).body(new CustomerError("Doesnt exist")):ResponseEntity.ok(c);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> handleAddCustomer(@RequestBody Customer c){
		try {
			Customer c1 = service.addNewCustomer(c);
			return ResponseEntity.ok(c1);
		}catch(Exception e){
			return ResponseEntity.status(404).body(new CustomerError("Error Occured " + e.getMessage()));
		}
	}
	
	@PutMapping(path="/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> handlePutCustomer(@PathVariable String id,@RequestBody Customer c){
		try {
			Customer c1 = service.updateCustomer(id,c);
			return ResponseEntity.ok(c1);
		}catch(Exception e){
			return ResponseEntity.status(404).body(new CustomerError("Error Occured " + e.getMessage()));
		}
	}
}
