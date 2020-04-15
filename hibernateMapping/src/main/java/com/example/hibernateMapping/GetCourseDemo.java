package com.example.hibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Course;
import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;

public class GetCourseDemo {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
				try {			
					
					// start a transaction
					session.beginTransaction();
					
					// get the instructor from db
					int theId = 1;
					Instructor tempInstructor = session.get(Instructor.class, theId);		
					
					System.out.println("Instructor: " + tempInstructor);
					
					// get courses for the instructor
					System.out.println("Courses: " + tempInstructor.getCourses());
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					
					// add clean up code
					session.close();
					
					factory.close();
				}
				
		
		
		
		
		
		
		
	}

	
}	