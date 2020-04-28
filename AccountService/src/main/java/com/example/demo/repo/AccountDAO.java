package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Account;

public interface AccountDAO extends CrudRepository<Account, Integer> {

}
