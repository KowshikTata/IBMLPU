package com.example.demo;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountDAO;

@SpringBootApplication
@EnableDiscoveryClient
public class MyAccountServiceApplication implements CommandLineRunner{
	
	private AccountDAO dao;
	
	
	
	public MyAccountServiceApplication(AccountDAO dao) {
		super();
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyAccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Account account=new Account(123,UUID.randomUUID().toString());
		dao.save(account);
		account=new Account(121,UUID.randomUUID().toString());
		dao.save(account);
	}

}
