package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Account;

public interface AccountService {

	public List<Account> getAll();
	
	public Account getById(int id);
	
	public Account create(Account account);
	
	public Account update(Account account);
	
	public Account delete(int id);
	
	
	
}
