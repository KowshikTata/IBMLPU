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


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/v1")
@Api(value="Employee Management System", description="helps in Management of mployees ")
public class EmployeeController {

	private EmployeeDAO employeeDAO;
	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	@ApiOperation(value = "View a list of available employees in Managemnet System", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/employees")
	public List<Employee> getAll()
	{
		return employeeDAO.getEmployees();
	}
	@ApiOperation(value = "View an particular employee in Managemnet System", response = List.class)
	
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
	@ApiOperation(value = "Creation of employee", response = List.class)
	
	@PostMapping("/employees")
	public Employee create(@RequestBody Employee employee)
	{
		return employeeDAO.createEmployee(employee);
	}
	@ApiOperation(value = "Update Employees in Employee Managemnet System", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
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
	@ApiOperation(value = "Delete  employees in Managemnet System", response = List.class)
	
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
