package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session currentsession=sessionfactory.openSession();
		currentsession.save(customer);
	
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session currentsession=sessionfactory.openSession();
		
		return currentsession.createQuery("from Customer",Customer.class).getResultList();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method s
		Session currentsession=sessionfactory.openSession();
		return currentsession.get(Customer.class,id);
	
	}

	@Override
	public Customer deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session currentsession=sessionfactory.openSession();
		Customer c=currentsession.get(Customer.class,id);
		if(c==null)
		{
			return null;
		}
		else
		{
			currentsession.beginTransaction();
			currentsession.remove(c);
			currentsession.getTransaction().commit();
			return c;
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session currentsession=sessionfactory.openSession();
		currentsession.getTransaction().begin();
			currentsession.saveOrUpdate(customer);
			currentsession.getTransaction().commit();
			return customer;
		}
	}


