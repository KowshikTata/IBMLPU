package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerDAO;
import com.example.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO dao;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.createCustomer(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return dao.getCustomers();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return dao.getCustomerById(id);
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		dao.deleteCustomer(id);
	}

	@Override
	public void updateCustomer(int id, String email) {
		// TODO Auto-generated method stub
		dao.updateCustomer(id, email);	
	}

}
