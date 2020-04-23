package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

@Repository
@EnableTransactionManagement
public class InstructorDetailDAOImpl implements InstructorDetailDAO{

	private EntityManager entityManager;
	
	
	
	public InstructorDetailDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public InstructorDetail createInstructorDetail(InstructorDetail instructorDetail) {
		Session session = entityManager.unwrap(Session.class);
		Instructor i=instructorDetail.getInstructor();
		i.setInstructorDetail(instructorDetail);
		session.save(i);
		session.save(instructorDetail);
		return null;
	}

	@Override
	@Transactional
	public List<InstructorDetail> getAllDetail() {
		Session session = entityManager.unwrap(Session.class);
		List<InstructorDetail> list=session.createQuery("from InstructorDetail",InstructorDetail.class).getResultList();
		return list;
	}

	@Override
	@Transactional
	public InstructorDetail getInstructorDetailById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(InstructorDetail.class, id);
	
	}

	@Override
	@Transactional
	public InstructorDetail deleteInstructorDetail(int id) {
		Session session = entityManager.unwrap(Session.class);
		InstructorDetail i=session.get(InstructorDetail.class, id);
		if(i==null)
		{
			return null;
		}
		session.remove(i);
		return i;
	}

	@Override
	@Transactional
	public InstructorDetail updateInstructorDetail(InstructorDetail instructorDetail) {
		Session session = entityManager.unwrap(Session.class);
		InstructorDetail i=session.get(InstructorDetail.class, instructorDetail.getId());
		if(i==null)
		{
		return null;
		}
		session.update(instructorDetail);
		session.update(instructorDetail.getInstructor());
		return instructorDetail;
		
	}

}
