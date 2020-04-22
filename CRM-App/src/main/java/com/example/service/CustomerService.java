package com.example.service;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerService {

public Customer createCustomer(Customer customer);
	
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(int id);
	
	public void deleteCustomer(int id);
	
	public void updateCustomer(int id,String email);
	
	
}
