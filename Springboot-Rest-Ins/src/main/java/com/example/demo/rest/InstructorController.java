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

import com.example.demo.dao.InstructorDAO;
import com.example.demo.entity.Instructor;

@RestController
@RequestMapping("/api")
public class InstructorController {

	@Autowired
	private InstructorDAO instructorDAO;
	
	
	@GetMapping("/instructors")
	public List<Instructor> getAll()
	{
		return instructorDAO.getAll();
	}
	@PostMapping("/instructors")
	public Instructor create(@RequestBody Instructor instructor)
	{
		return instructorDAO.createInstructor(instructor);
	}
	@GetMapping("/instructors/{id}")
	public Instructor getById(@PathVariable("id") int id) throws InstructorNotFoundException
	{
		
		Instructor i=instructorDAO.getInstructorById(id);
		if(i==null) {
			throw new InstructorNotFoundException("no instructor found with id= "+id);
		}
		return i;
	}
	@ExceptionHandler
	public ResponseEntity<InstructorResponseEntity> handleInstructorNotFoundException(InstructorNotFoundException infe)
	{
		return new ResponseEntity<InstructorResponseEntity>(new InstructorResponseEntity(HttpStatus.NOT_FOUND.value(),infe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	@PutMapping("/instructors")
	public Instructor update(@RequestBody Instructor instructor) throws InstructorNotFoundException
	{
		Instructor i= instructorDAO.updateInstructor(instructor);
		if(i==null) {
			throw new InstructorNotFoundException("no instructor found with id= "+instructor.getId());
		}return i;
	}
	@DeleteMapping("/instructors/{id}")
	public Instructor del(@PathVariable("id") int id) throws InstructorNotFoundException
	{
		Instructor i=instructorDAO.deleteInstructor(id);
		
		if(i==null) {
			throw new InstructorNotFoundException("no instructor found with id= "+id);
		}
		return i;
	}
	
}
