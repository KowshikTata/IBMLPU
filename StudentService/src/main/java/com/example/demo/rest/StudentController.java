package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	@RequestMapping("/getStudents/{name}")
	public List<Student> get(@PathVariable("name") String name)
	{
		return  service.findBySchoolName(name);
	}
	
}
