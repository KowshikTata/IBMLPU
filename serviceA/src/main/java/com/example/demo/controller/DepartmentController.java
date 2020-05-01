package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.EmployeeClient;
@EnableAutoConfiguration
@RequestMapping("/api")
@RestController
public class DepartmentController {

	private EmployeeClient client;

	public DepartmentController(EmployeeClient client) {
		super();
		this.client = client;
	}
	@RequestMapping("/departments/hello")
	public ResponseEntity<String> call(@RequestParam String name)
	{
		String result=client.callHi(name);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
