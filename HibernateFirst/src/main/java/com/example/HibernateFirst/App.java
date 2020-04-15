package com.example.HibernateFirst;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.exaample.domain.Student;
import com.example.service.StudentService;
import com.example.service.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static StudentService service=new StudentServiceImpl();;
	private static Scanner scanner=new Scanner(System.in);
	
    public static void main( String[] args )
    {
       String fname,lname,email;
       int ch=-1;
       do
       {
    	   System.out.println("1.create student");
    	   System.out.println("2.display all students");
    	   System.out.println("3.Display student by id");
    	   System.out.println("4.Exit");
    	   System.out.println("enter choice");
    	   ch=scanner.nextInt();
    	   switch(ch)
    	   {
    	   case 1:
    		   Student student=new Student();
    		   //student.setId(UUID.randomUUID().toString());
    		   System.out.println("enter first name");
    		   fname=scanner.next();
    		   student.setFirstName(fname);
    		   System.out.println("enter last name");
    		   lname=scanner.next();
    		   student.setLastName(lname);
    		   System.out.println("enter email");
    		   email=scanner.next();
    		   student.setEmail(email);
    		   
    		   service.createStudent(student);
    		   break;
    	   case 2:
    		  List<Student> list= service.getStudents();
    		  for(Student li:list)
    		  {
    			  System.out.println(li);
    		  }
    		   break;
    	   case 3:  
    		   System.out.println("enter id");
    		   String id=scanner.next();
      		 Student st=service.getStudentById(id);
      		 if(st==null)
      		 {
      			 System.out.println("no id exist with"+id);
      		 }
      		 else
      		 {
      			 System.out.println(st);
      		 }
      		 break;
    	   case 4:
    		   System.exit(0);
    		   break;
    	  
    	   default:
    		   System.out.println("select from 1-4");
    		   break;
    	   }
    	   
    	   
    	   
       }while(ch!=4);
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
