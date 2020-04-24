package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.ImageRepo;

@SpringBootApplication
public class SpringBootRestAutoApplication {

	private ImageRepo imageRepo;
	
	public SpringBootRestAutoApplication(ImageRepo imageRepo) {
		super();
		this.imageRepo = imageRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestAutoApplication.class, args);
	}

}
