package com.example.demo.dao;

import java.util.List;

import com.example.demo.data.Employee;

public interface EmployeeDAO {
	
	public Employee createEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(int id);
	
	public Employee deleteEmployee(int id);
	
	public Employee updateEmployee(Employee employee);

}
