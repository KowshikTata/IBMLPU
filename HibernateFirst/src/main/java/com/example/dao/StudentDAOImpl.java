package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exaample.domain.Student;
import com.example.factory.MyHibernateFactory;

public class StudentDAOImpl implements StudentDAO{
	
	private  MyHibernateFactory factory=null;
	private SessionFactory sessionFactory=null;
	private Session session=null;
	
	{
		factory=MyHibernateFactory.getMyHibernateFactory();
		sessionFactory=factory.getSessionFactory();
		session=sessionFactory.openSession();
	}

	

	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		return student;
	}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		
		List<Student> list=session.createQuery("from Student",Student.class).list();
		return list;
	}

}
