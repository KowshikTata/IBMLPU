package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Event;

public interface EventDAO {

	public Event createEvent(Event event);
	
	public List<Event> getEvents();
	
	public Event getEventById(int id);
	
	public void removeEvent(int id);
	
	public Event assignSpeaker(int id,int eid);
	
}
