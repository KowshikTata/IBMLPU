package com.example.demo.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Speaker;

@Repository
public class SpeakerDAOImpl implements SpeakerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private EntityManagerFactory factory;
	private EntityManager entityManager;
	
	

	@PostConstruct
	public void init() {
		factory = sessionFactory.unwrap(SessionFactory.class);
		entityManager = factory.createEntityManager();
	}
	
	

	public Speaker createSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(speaker);
		entityManager.getTransaction().commit();
		return speaker;
	}

	public List<Speaker> getSpeakers() {
		List<Speaker> list=entityManager.createQuery("select s from Speaker s",Speaker.class).getResultList();
		return list;
	}

	public Speaker getSpeakerById(int id) {
		// TODO Auto-generated method stub
		Speaker speaker=entityManager.find(Speaker.class, id);
		if(speaker==null)
		{
		return null;
		}
		else
		{
			return speaker;
		}
	}

	public void removeSpeaker(int id) {
		// TODO Auto-generated method stub

		Speaker speaker=entityManager.find(Speaker.class, id);
		if(speaker==null)
		{
		System.out.println("no record found with id= "+id);
		}
		else
		{
			entityManager.getTransaction().begin();
			entityManager.remove(speaker);
			entityManager.getTransaction().commit();
		}
		
	}


}
