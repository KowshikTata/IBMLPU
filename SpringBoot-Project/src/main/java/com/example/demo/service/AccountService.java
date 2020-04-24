package com.example.demo.service;

import java.util.Optional;

import com.example.demo.data.Account;

public interface AccountService {

	public Iterable<Account> getAll();
	
	public Optional<Account> get(int id);
}
