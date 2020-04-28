package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {

}
