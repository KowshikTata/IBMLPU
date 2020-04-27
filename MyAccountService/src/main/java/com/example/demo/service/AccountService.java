package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Account;

public interface AccountService {

	public List<Account> getAll();
	
	public Account getById(Integer id);
	
	public Account createAccount(Account account);
	
	public Account deleteAccount(Integer id);
	
	public Account updateAccount(Account account);
	
}
