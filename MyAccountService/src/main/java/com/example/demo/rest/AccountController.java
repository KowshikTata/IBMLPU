package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;

import com.example.demo.service.AccountService;

@RestController
public class AccountController {
	
	private AccountService service;

	
	
	public AccountController(AccountService service) {
		super();
		this.service = service;
	}



	@RequestMapping("/accounts")
	public List<Account> getAll()
	{
		return service.getAll();
	}
	
	@RequestMapping("/account/{id}")
	public Account getAll(@PathVariable("id") Integer id)
	{
		return service.getById(id);
	}
	@PutMapping("/account")
	public Account update(@RequestBody Account account)
	{
		return service.updateAccount(account);
	}
	@DeleteMapping("/account/{id}")
	public Account del(@PathVariable("id") Integer id)
	{
		return service.deleteAccount(id);
	}
	@PostMapping("/account")
	public Account save(@RequestBody Account account)
	{
		return service.createAccount(account);
	}
	
}
