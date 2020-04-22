package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.CustomerResponseEntity;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService service;
	@RequestMapping("/customers")
	public List<Customer> getCustomer()
	{
		return service.getCustomers();
		
	}
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) throws CustomerNotFoundException
	{
		
		Customer c=service.getCustomerById(id);
		if(c==null)
		{
		
			throw new CustomerNotFoundException("no customer found with id ="+id);
		}
		return c;
	}
	@ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleCustomerNotFoundException(CustomerNotFoundException cnfe)
	{
		return new ResponseEntity<CustomerResponseEntity>(new CustomerResponseEntity(HttpStatus.NOT_FOUND.value(),cnfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
		
	}
	
	
}
