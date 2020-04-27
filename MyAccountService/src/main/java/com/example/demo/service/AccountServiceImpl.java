package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountDAO;
@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountDAO dao;

	
	
	public AccountServiceImpl(AccountDAO dao) {
		super();
		this.dao = dao;
	}



	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return (List<Account>) dao.findAll();
	}



	@Override
	public Account getById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}
