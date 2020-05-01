package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SchoolService {

	@Autowired
	RestTemplate restTemplate;
	
	public List get(String name)
	{
		return restTemplate.getForObject("http://student-service/getStudents"+name, List.class);
	}
}
