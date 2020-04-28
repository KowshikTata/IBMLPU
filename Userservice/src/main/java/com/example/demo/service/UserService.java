package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;
	
	public List getAll()
	{
		return restTemplate.getForObject("http://movie-service/movies",List.class);
	}
	public Object findById(int id)
	{
		return restTemplate.getForObject("http://movie-service/movie",Object.class);
	}
	public Object delete(int id)
	{
		return restTemplate.getForObject("http://movie-service/movie",Object.class);
	}
	public Object save(Object o)
	{
		return restTemplate.getForObject("http://movie-service/movie",Object.class);
	}
	public Object update(Object o)
	{
		return restTemplate.getForObject("http://movie-service/movie",Object.class);
	}
}
