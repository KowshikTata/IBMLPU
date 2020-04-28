package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerDAO;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO dao;

	public CustomerServiceImpl(CustomerDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) dao.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return dao.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		Customer c=dao.findById(customer.getId()).get();
		if(c==null)
		{
		return null;
		}
		else
		{
			return dao.save(c);
			
		}
	}

	@Override
	public Customer delete(int id) {
		Customer c=dao.findById(id).get();
		if(c==null)
		{
		return null;
		}
		else
		{
			dao.delete(c);
			return c;
		}
		
	}

	@Override
	public Customer getById(int id) {
		
		return dao.findById(id).get();
	}

}
