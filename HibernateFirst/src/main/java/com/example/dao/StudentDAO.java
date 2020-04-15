package com.example.dao;
import java.util.List;

import com.exaample.domain.Student;
public interface StudentDAO {
	
	public Student createStudent(Student student);
		
	public List<Student> getStudents();
	
	public Student getStudentById(String id);
		
	public Student updateByFname(String fname,String email);	
}
