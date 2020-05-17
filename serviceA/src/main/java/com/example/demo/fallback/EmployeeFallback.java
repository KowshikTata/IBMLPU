package com.example.demo.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.client.EmployeeClient;
import com.example.demo.model.Employee;

@Component
public class EmployeeFallback implements EmployeeClient {

	@Override
	public String callHi(String name) {
		// TODO Auto-generated method stub
		return "<p>The Service you requested is currently Unavailable come back later<p>";
	}

	@Override
	public List<Employee> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
