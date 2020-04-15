package com.example.OneToOne;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Student;
import com.example.entity.StudentDetail;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner=new Scanner(System.in);
    	SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(StudentDetail.class).buildSessionFactory();
    	Session session=factory.openSession();
    	
    	try {
    		int ch=0;
    		do
    		{
    		System.out.println("1.create Student");	
    		System.out.println("2.Get Students");	
    		System.out.println("3.Get Student by Id");	
    		System.out.println("4.Delete Student");
    		System.out.println("5.Exit");	
    		System.out.println("enter choice");
    		ch=scanner.nextInt();
    		String fname,lname,email,adress,hobby;
    		switch(ch)
    		{
    		case 1:
    			System.out.println("enter fname");
    			fname=scanner.next();
    			System.out.println("enter lname");
    			lname=scanner.next();
    			System.out.println("enter email");
    			email=scanner.next();
    			
    			System.out.println("enter adress");
    			adress=scanner.next();
    			System.out.println("enter hobby");
    			hobby=scanner.next();
    			session.beginTransaction();
    			StudentDetail st=new StudentDetail();
    			st.setAddress(adress);
    			st.setHobby(hobby);
    			Student student=new Student();
    			student.setFirstName(fname);
    			student.setLastName(lname);
    			student.setEmail(email);
    			student.setStudentDetail(st);
    			session.save(student);
    			session.getTransaction().commit();
    			break;
    		case 2:
    			List<Student> list=session.createQuery("from Student",Student.class).list();
    			for(Student li:list)
    			{
    				System.out.println(li);
    			}
    			break;
    		case 3:
    			System.out.println("enter id");
    			int id=scanner.nextInt();
    			student=session.get(Student.class,id);
    			if(student==null)
    			{
    				System.out.println("no record found with id="+id);
    			}
    			else
    			{
    			System.out.println(student);
    			}
    			break;
    		case 4:
    			System.out.println("enter id");
    			 id=scanner.nextInt();
    			 student=session.get(Student.class,id);
    			 if(student==null)
     			{
     				System.out.println("no record found with id="+id);
     			}
     			else
     			{
     				session.beginTransaction();
    			session.delete(student);
     				session.getTransaction().commit();
    			System.out.println("deleted!!");
     			}
    			break;
    		case 5:
    			System.exit(0);
    			break;
    		default:
    			System.out.println("select from 1-5");
    			break;
    		
    		
    		}
    		
    		
    		
    		
    		}while(ch!=5);
    	}
    	finally {
    		
    		session.close();
    		factory.close();
    		
    	}
    	
    	
    	
    }
}
