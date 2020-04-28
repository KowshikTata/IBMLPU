package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;



@RestController
public class CustomerController {

private CustomerService service;
	
	

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	@Value("${server.port}")
	int port;
	
	@RequestMapping("/customers")
	public List<Customer> getAll()
	{
		System.out.println("the request is coming from port= "+port);
		return service.getAll();
	}
	@RequestMapping("/customer/{id}")
	public Customer getAll(@PathVariable("id") int id)
	{
		return service.getById(id);
	}
	@PostMapping("/customer")
	public Customer create(@RequestBody Customer customer)
	{
		return service.save(customer);
	}
	@PutMapping("/customer")
	public Customer update(@RequestBody Customer customer)
	{
		return service.update(customer);
	}
	@DeleteMapping("/customer/{id}")
	public Customer del(@PathVariable("id") int id)
	{
		return service.delete(id);
	}
	
	
}
