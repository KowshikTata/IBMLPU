package com.example.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CustomerDAO;
import com.example.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO dao;

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.createCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return dao.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return dao.getCustomerById(id);
	}

	@Override
	@Transactional
	public Customer deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(id);
	}

	@Override
	
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(customer);	
	}

}
