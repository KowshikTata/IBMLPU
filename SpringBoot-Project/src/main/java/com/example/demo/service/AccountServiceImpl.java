package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dao.AccountDAO;
import com.example.demo.data.Account;
@EnableTransactionManagement
@Service(value="service")
public class AccountServiceImpl implements AccountService{

	
	private AccountDAO accountDAO;
	
	public AccountServiceImpl(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	@Override
	public Iterable<Account> getAll() {
		// TODO Auto-generated method stub
		return accountDAO.findAll();
	}

	@Override
	public Optional<Account> get(int id) {
		// TODO Auto-generated method stub
		return accountDAO.findById(id);
	}

	
}
