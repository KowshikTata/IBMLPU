package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Instructor;

public interface InstructorDAO {

	public Instructor createInstructor(Instructor instructor);
	
	public List<Instructor> getAll();
	
	public Instructor getInstructorById(int id);
	
	public Instructor deleteInstructor(int id);
	
	public Instructor updateInstructor(Instructor instructor);
	
	
	
	
	
	
}
