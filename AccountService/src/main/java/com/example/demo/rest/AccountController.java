package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/accounts")
	public List<Account> getAll()
	{
		System.out.println("the request is coming from port= "+port);
		return service.getAll();
	}
	@RequestMapping("/account/{id}")
	public Account getAll(@PathVariable("id") int id)
	{
		return service.getById(id);
	}
	@PostMapping("/account")
	public Account create(@RequestBody Account account)
	{
		return service.create(account);
	}
	@PutMapping("/account")
	public Account update(@RequestBody Account account)
	{
		return service.update(account);
	}
	@DeleteMapping("/account/{id}")
	public Account del(@PathVariable("id") int id)
	{
		return service.delete(id);
	}
	
}
