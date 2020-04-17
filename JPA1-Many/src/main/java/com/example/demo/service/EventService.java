package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Event;

public interface EventService {

public Event createEvent(Event event);
	
	public List<Event> getEvents();
	
	public Event getEventById(int id);
	
	public void removeEvent(int id);
	
	public Event assignSpeaker(int sid, int eid);
	
}
