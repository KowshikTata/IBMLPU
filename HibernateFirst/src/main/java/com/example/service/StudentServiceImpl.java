package com.example.service;

import java.util.List;

import com.exaample.domain.Student;
import com.example.dao.StudentDAO;
import com.example.dao.StudentDAOImpl;

public class StudentServiceImpl implements StudentService{
	
	private StudentDAO dao;
	{
		dao=new StudentDAOImpl();
	}

	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.createStudent(student);
	}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return dao.getStudents();
	}

	public Student getStudentById(String id) {
		// TODO Auto-generated method stub
		return dao.getStudentById(id);
	}

	public Student updateByFname(String fname, String email) {
		// TODO Auto-generated method stub
		return dao.updateByFname(fname, email);
	}

}
