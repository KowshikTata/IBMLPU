package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;

@SpringBootApplication
public class SpringThymeleafApplication implements CommandLineRunner{

	private ProductDAO dao;
	
	
	
	public SpringThymeleafApplication(ProductDAO dao) {
		super();
		this.dao = dao;
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Product product=new Product("cell phone mi",7000.00,"mi.com");
		dao.save(product);
		product=new Product("cell phone samsung",10000.00,"samsung.com");
		dao.save(product);
		
		
	}

}
