package com.example.demo.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Event;
import com.example.demo.entity.Speaker;
@Repository
public class EventDAOImpl implements EventDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private EntityManagerFactory factory;
	private EntityManager entityManager;
	
	

	@PostConstruct
	public void init() {
		factory = sessionFactory.unwrap(SessionFactory.class);
		entityManager = factory.createEntityManager();
	}
	
	

	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(event);
		entityManager.getTransaction().commit();
		return event;
		
		
			
		
	}

	public List<Event> getEvents() {
		List<Event> list=entityManager.createQuery("select e from Event e",Event.class).getResultList();
		return list;
	}

	public Event getEventById(int id) {
		// TODO Auto-generated method stub
		Event event=entityManager.find(Event.class,id);
		if(event==null)
		{
		return null;
		}
		else
		{
			return event;
		}
	}

	public void removeEvent(int id) {
		// TODO Auto-generated method stub

		Event event=entityManager.find(Event.class,id);
		if(event==null)
		{
		System.out.println("no record found with id= "+id);
		}
		else
		{
			entityManager.getTransaction().begin();
			entityManager.remove(event);
			entityManager.getTransaction().commit();
		}
		
	}



	public Event assignSpeaker(int sid, int eid) {
		// TODO Auto-generated method stub
		Event ev=entityManager.find(Event.class,eid);
		Speaker s=entityManager.find(Speaker.class,sid);
		entityManager.getTransaction().begin();
		ev.setSpeaker(s);
		entityManager.merge(ev);
		entityManager.getTransaction().commit();
		return ev;
	
		
	}

}
