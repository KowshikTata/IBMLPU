package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;
import com.example.demo.rest.UserDAO;

@SpringBootApplication
@EnableDiscoveryClient

public class UserserviceApplication implements CommandLineRunner{
	
	@Autowired
	private UserDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user=new User("Tata Kowshik","VJA");
		dao.save(user);
		user=new User("John","DEN");
		dao.save(user);
	}
}
