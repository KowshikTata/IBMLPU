package com.example.hibernateMapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	SessionFactory factory=new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
    	
    	Session session=factory.openSession();
    	//for instructor and instructor detail
		/*
		 * Instructor ins=new Instructor(); ins.setFirstName("Nilay");
		 * ins.setLastName("Singh"); ins.setEmail("nilay@gmailcom"); InstructorDetail
		 * insd=new InstructorDetail(); insd.setHobby("Teaching");
		 * insd.setYoutubeChannel("luv2Code"); ins.setInstructorDetail(insd);
		 * session.beginTransaction();
		 * 
		 * session.save(ins);
		 * 
		 * session.getTransaction().commit();
		 * 
		 * List<Instructor>
		 * list=session.createQuery("from Instructor",Instructor.class).list();
		 * for(Instructor li:list) { System.out.println(li); }
		 */
    	//for image and album
    	
    	
    	
    	
    }
}
