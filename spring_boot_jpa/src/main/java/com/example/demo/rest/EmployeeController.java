package com.example.demo.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.data.Employee;



@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeDAO employeeDAO;
	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll()
	{
		return employeeDAO.getEmployees();
	}
	@GetMapping("/employees/{id}")
	public Employee getAll(@PathVariable("id") int id) throws EmployeeNotFoundException
	{
		
		Employee e=employeeDAO.getEmployeeById(id);
		if(e==null)
		{
			throw new EmployeeNotFoundException("no employee found with id = "+id);
		}
		return e;
	}
	@PostMapping("/employees")
	public Employee create(@RequestBody Employee employee)
	{
		return employeeDAO.createEmployee(employee);
	}
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) throws EmployeeNotFoundException
	{
	 Employee e=employeeDAO.updateEmployee(employee);
	 if(e==null)
	 {
		 throw new EmployeeNotFoundException("no employee found with id = "+employee.getId());
	 }
	 return e;
	}
	@DeleteMapping("/employees/{id}")
	public Employee del(@PathVariable("id") int id) throws EmployeeNotFoundException
	{
		Employee e=employeeDAO.deleteEmployee(id);
		 if(e==null)
		 {
			 throw new EmployeeNotFoundException("no employee found with id = "+id);
		 }
		 return e;
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeResponseEntity> handleEnfe(EmployeeNotFoundException enfe)
	{
	return new ResponseEntity<EmployeeResponseEntity>(new EmployeeResponseEntity(HttpStatus.NOT_FOUND.value(),enfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	
	
}
