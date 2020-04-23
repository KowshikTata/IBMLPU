package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Instructor;

@Repository("instructorDAO")
@EnableTransactionManagement
public class InstructorDAOImpl implements InstructorDAO{
	
	private EntityManager entityManager;
	
	
	public InstructorDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Instructor createInstructor(Instructor instructor) {
		Session session = entityManager.unwrap(Session.class);
		session.save(instructor);
		return instructor;
	}

	@Override
	@Transactional
	public List<Instructor> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Instructor> list=session.createQuery("from Instructor",Instructor.class).getResultList();
		
		return list;
	}

	@Override
	@Transactional
	public Instructor getInstructorById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Instructor.class,id);
	
	}

	@Override
	@Transactional
	public Instructor deleteInstructor(int id) {
		Session session = entityManager.unwrap(Session.class);
		Instructor i=session.get(Instructor.class, id);
		if(i==null)
		{
		return null;
		}
		session.remove(i);
		return i;
	}

	@Override
	@Transactional
	public Instructor updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Instructor i=session.get(Instructor.class, instructor.getId());
		if(i==null)
		{
		return null;
		}
		session.merge(instructor);
		return instructor;
	}

	
	
	
	
	
	
	
	
	
}
