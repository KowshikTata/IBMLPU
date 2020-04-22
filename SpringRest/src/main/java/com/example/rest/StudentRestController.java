package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.exception.StudentNotFoundException;
import com.example.exception.StudentResponseEntity;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> list=null;
	@PostConstruct
	public void init()
	{
		list=new ArrayList<>();
		list.add(new Student("Tata","Kowshik"));
		list.add(new Student("Rod","Johnson"));
		list.add(new Student("Dennis","Richie"));
	}
	@RequestMapping("/students")
	public List<Student> getStudents()
	{ 
		return list;
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student)
	{
		list.add(student);
		return student;
	}
	
	@RequestMapping("/students/{studentID}")
	public Student getStudentById(@PathVariable int studentID) throws StudentNotFoundException
	{ 
		if((studentID>=list.size())||(studentID<0))
		{
			throw new StudentNotFoundException("no student found with id= "+studentID);
		}
		return list.get(studentID);
	}
	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleException(StudentNotFoundException snfe)
	{
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.NOT_FOUND.value(),snfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleNumberFormatException(NumberFormatException ipme)
	{
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.BAD_REQUEST.value(),"must be Numeric",System.currentTimeMillis()),HttpStatus.BAD_REQUEST);
	}
	
}
