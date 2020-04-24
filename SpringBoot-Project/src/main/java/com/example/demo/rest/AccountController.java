package com.example.demo.rest;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	private AccountService service;

	public AccountController(AccountService service) {
		super();
		this.service = service;
	}

	@GetMapping("/accounts")
	public Iterable<Account> findAll()
	{
		return service.getAll();
	}
	@GetMapping("/accounts/{id}")	
	public Optional<Account> find(@PathVariable("id") int id)
	{
		return service.get(id);
	}
	
	
}
