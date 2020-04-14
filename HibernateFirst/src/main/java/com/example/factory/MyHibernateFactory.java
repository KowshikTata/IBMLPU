package com.example.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.exaample.domain.Student;

public class MyHibernateFactory {

	private SessionFactory sessionfactory;
	
	private static MyHibernateFactory factory;
	
	private MyHibernateFactory()
	{
		
	}
	
	public SessionFactory getSessionFactory()
	{
		sessionfactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		return sessionfactory;
		
	}
	public static  MyHibernateFactory getMyHibernateFactory()
	{
		if(factory==null)
		{
			factory=new MyHibernateFactory();
		}
		return factory;
		
	}
	
}
