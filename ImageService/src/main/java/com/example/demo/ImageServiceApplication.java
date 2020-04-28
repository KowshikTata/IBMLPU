package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.model.Image;
import com.example.demo.repo.ImageDAO;

@SpringBootApplication
@EnableEurekaClient
public class ImageServiceApplication implements CommandLineRunner{
	
	private ImageDAO dao;
	
	

	public ImageServiceApplication(ImageDAO dao) {
		super();
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(ImageServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Image image=new Image("image1","iamge1.com");
		dao.save(image);
		image=new Image("image2","iamge2.com");
		dao.save(image);
	}

}
