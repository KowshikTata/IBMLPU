package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Movie;
import com.example.demo.repo.MovieDAO;

@SpringBootApplication
public class MovieServiceApplication implements CommandLineRunner{
	
	private MovieDAO dao;

	
	
	public MovieServiceApplication(MovieDAO dao) {
		super();
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Movie movie=new Movie("Bahubali",9.2);
		dao.save(movie);
		movie=new Movie("Bahubali2",9.5);
		dao.save(movie);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
