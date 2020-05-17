package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public interface EmployeeService {
	Iterable<Employee> findByDepartmentName(String departmentName);
}
