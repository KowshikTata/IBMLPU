package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class EmployeeController {

	@RequestMapping("/employees/hi")
	public String call(@RequestParam String name)
	{
		return "Hello "+name;
	}
	
}
