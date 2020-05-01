package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.StudentDAO;
import com.example.demo.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO dao;
	
	

	public StudentServiceImpl(StudentDAO dao) {
		super();
		this.dao = dao;
	}



	@Override
	public List<Student> findBySchoolName(String schoolName) {
		// TODO Auto-generated method stub
		return (List<Student>) dao.findBySchoolName(schoolName);
	}

}
