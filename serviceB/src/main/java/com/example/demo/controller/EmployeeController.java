package com.example.demo.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService service;

	
	
	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	@RequestMapping("/employees/hi")
	public String call(@RequestParam String name)
	{
		return "Hello "+name;
	}
	@RequestMapping("/employees/findEmployee")
	public List<Employee> find(@RequestParam String name)
	{
		return (List<Employee>) service.findByDepartmentName(name);
	}
}
