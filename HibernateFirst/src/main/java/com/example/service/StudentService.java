package com.example.service;

import java.util.List;

import com.exaample.domain.Student;

public interface StudentService {

	public Student createStudent(Student student);
	
	public List<Student> getStudents();
	
	public Student getStudentById(String id);
}
