package com.example.demo;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.dao.EventDAO;
import com.example.demo.dao.EventDAOImpl;
import com.example.demo.entity.Event;
import com.example.demo.entity.Speaker;
import com.example.demo.service.EventService;
import com.example.demo.service.EventServiceImpl;
import com.example.demo.service.SpeakerService;
import com.example.demo.service.SpeakerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
        
    	Scanner scanner=new Scanner(System.in);
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EventService eventService = context.getBean("EventServiceImpl", EventServiceImpl.class);
		SpeakerService speakerService=context.getBean("SpeakerServiceImpl",SpeakerServiceImpl.class);
		
		/*
		 * EventDAO dao=context.getBean("Eventdao", EventDAOImpl.class); List<Event>
		 * list=dao.getEvents(); for(Event li:list) { System.out.println(li); }
		 */
		/*
		 * //create speakers Speaker s1=new Speaker("kowshik","kowshik@gmail.com",true);
		 * speakerDao.createSpeaker(s1); Speaker s2=new
		 * Speaker("Instructor","ins@gmail.com",true); speakerDao.createSpeaker(s2);
		 * 
		 * //getSpeakers List<Speaker> list=speakerDao.getSpeakers();
		 * 
		 * for(Speaker li:list) { System.out.println(li); }
		 */
    	//create Events
		//Speaker s1=speakerDao.getSpeakerById(5);
		/*
		 * Event e1=new Event(); e1.setDate(new Date(17/04/2020));
		 * e1.setEventname("event3"); e1.setDuration(5);
		 * 
		 * Event e2=new Event(); e2.setDate(new Date(18/04/2020));
		 * e2.setEventname("event3"); e2.setDuration(6);
		 */
    	//s1.add(e1);
    	//s1.add(e2);
		/*
		 * Event e1=eventDao.getEventById(1); Event e2=eventDao.getEventById(2);
		 * e1.setSpeaker(s1); e2.setSpeaker(s1); eventDao.createEvent(e1);
		 * eventDao.createEvent(e2);
		 */
		int ch=0;
		do
		{
		System.out.println("1.create Speaker");	
		System.out.println("2.Get All Speaker");	
		System.out.println("3.GetSpeaker by Id");	
		System.out.println("4.Remove Speaker");
		System.out.println("5.create Event");	
		System.out.println("6.Get All Event");	
		System.out.println("7.GetSpeaker by Id");	
		System.out.println("8.Remove Event");
		System.out.println("9.Add Speaker to Event");
		System.out.println("10.Exit");	
		System.out.println("enter choice");
		ch=scanner.nextInt();
		String name,email,eventname,date1;
		int duration;
		Date date;
		Boolean isAvailable;
		int id;
		switch(ch)
		{
		case 1:	Speaker speaker=new Speaker();
				System.out.println("enter name");
				name=scanner.next();
				System.out.println("enter email");
				email=scanner.next();
				System.out.println("enter availability");
				isAvailable=scanner.nextBoolean();
				speaker.setEmail(email);
				speaker.setName(name);
				speaker.setIsAvailable(isAvailable);
				speakerService.createSpeaker(speaker);
				break;
		case 2:	List<Speaker> list1=speakerService.getSpeakers();
				for(Speaker li:list1)
				{
					System.out.println(li);
				}
				break;
		case 3:	
				System.out.println("enter id");
				id=scanner.nextInt();
				Speaker s=speakerService.getSpeakerById(id);
				if(s==null)
				{
					System.out.println("no speaker found with id= "+id);
				}
				else
				{
					System.out.println(s);
				}
				break;
		case 4:	System.out.println("enter id");
				id=scanner.nextInt();
				speakerService.removeSpeaker(id);
				System.out.println("deleted");
				break;
		case 5:	Event event=new Event();
				System.out.println("enter event name");
				eventname=scanner.next();
				System.out.println("enter duration");
				duration=scanner.nextInt();
				System.out.println("enetr date in dd-mm-yyyy format");
				SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
				date1=scanner.next();
				date=format.parse(date1);
				event.setDate(date);
				event.setDuration(duration);
				event.setEventname(eventname);
				eventService.createEvent(event);
				break;
		case 6: List<Event> elist=eventService.getEvents();
				for(Event li:elist)
				{
					System.out.println(li);
				}
				break;
		case 7:	
				System.out.println("enter id");
				id=scanner.nextInt();
				Event e=eventService.getEventById(id);
				if(e==null)
				{
					System.out.println("no event found with id= "+id);
				}
				else
				{
					System.out.println(e);
				}
				break;
		case 8:	System.out.println("enter id");
				id=scanner.nextInt();
				eventService.removeEvent(id);
				System.out.println("deleted");
				break;
		case 9: System.out.println("enter id of speaker");
				int sid=scanner.nextInt();
				System.out.println("enter id of event");
				int eid=scanner.nextInt();
			
				
				Event ev=eventService.assignSpeaker(sid, eid);
				if(ev==null)
				{
					System.out.println("not found");
				}
				else
				{
					System.out.println(ev);
				}
				break;
		case 10:	System.exit(0);
				break;
    	default:System.out.println("choose from 1-10");
    	break;
    	
    	
		}
		
		}while(ch!=10);
		
    	
    	
    }
}
