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
		
		return dao.findById(id).get();
	}



	@Override
	public Account createAccount(Account account) {
		
		return dao.save(account);
	}



	@Override
	public Account deleteAccount(Integer id) {
		Account account=dao.findById(id).get();
		if(account==null)
		{
			return null;
		}
		else
		{
		dao.deleteById(id);
		return account;
		}
	}



	@Override
	public Account updateAccount(Account account) {
		Account acc=dao.findById(account.getId()).get();
		if(acc==null)
		{
			return null;
		}
		else
		{
		return dao.save(account);
		}
	}

}
