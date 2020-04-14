package com.example.dao;
import java.util.List;

import com.exaample.domain.Student;
public interface StudentDAO {
	
	public Student createStudent(Student student);
		
	public List<Student> getStudents();
		
		
}
