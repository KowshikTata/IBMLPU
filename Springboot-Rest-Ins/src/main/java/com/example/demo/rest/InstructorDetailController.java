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
import com.example.demo.dao.InstructorDetailDAO;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

@RestController
@RequestMapping("/api")
public class InstructorDetailController {

	@Autowired
	private InstructorDetailDAO instructorDetailDAO;
	
	
	@GetMapping("/instructordetails")
	public List<InstructorDetail> getAll()
	{
		return instructorDetailDAO.getAllDetail();
	}
	@PostMapping("/instructordetails")
	public InstructorDetail create(@RequestBody InstructorDetail instructor)
	{
		return instructorDetailDAO.createInstructorDetail(instructor);
	}
	@GetMapping("/instructordetails/{id}")
	public InstructorDetail getById(@PathVariable("id") int id) throws InstructorDetailNotFoundException
	{
		
		InstructorDetail i=instructorDetailDAO.getInstructorDetailById(id);
		if(i==null) {
			throw new InstructorDetailNotFoundException("no instructorDetail found with id= "+id);
		}
		return i;
	}
	@ExceptionHandler
	public ResponseEntity<InstructorDetailResponseEntity> handleInstructorDetailNotFoundException(InstructorDetailNotFoundException idnfe)
	{
		return new ResponseEntity<InstructorDetailResponseEntity>(new InstructorDetailResponseEntity(HttpStatus.NOT_FOUND.value(),idnfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	@PutMapping("/instructordetails")
	public InstructorDetail update(@RequestBody InstructorDetail instructorDetail) throws InstructorDetailNotFoundException
	{
		InstructorDetail i= instructorDetailDAO.updateInstructorDetail(instructorDetail);
		if(i==null) {
			throw new InstructorDetailNotFoundException("no instructorDetail found with id= "+instructorDetail.getId());
		}return i;
	}
	@DeleteMapping("/instructordetails/{id}")
	public InstructorDetail del(@PathVariable("id") int id) throws InstructorDetailNotFoundException
	{
		InstructorDetail i=instructorDetailDAO.deleteInstructorDetail(id);
		
		if(i==null) {
			throw new InstructorDetailNotFoundException("no instructorDetail found with id= "+id);
		}
		return i;
	}
	
	
	
	
}