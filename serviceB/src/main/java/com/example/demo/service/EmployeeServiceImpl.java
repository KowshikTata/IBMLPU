package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO dao;

	@Override
	public Iterable<Employee> findByDepartmentName(String departmentName) {
		// TODO Auto-generated method stub
		return dao.findByDepartmentName(departmentName);
	}

	
	
}
