package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {

	public List<Customer> getAll();
	
	public Customer save(Customer customer);
	
	public Customer update(Customer customer);
	
	public Customer delete(int id);
	
	public Customer getById(int id);
}
