package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EventDAO;

import com.example.demo.entity.Event;
@Service("EventServiceImpl")
public class EventServiceImpl implements EventService{
	
	private EventDAO dao;
	@Autowired
	public  EventServiceImpl(EventDAO dao)
	{
		super();
		this.dao=dao;
	}

	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		return dao.createEvent(event);
	}

	public List<Event> getEvents() {
		// TODO Auto-generated method stub
		return dao.getEvents();
	}

	public Event getEventById(int id) {
		// TODO Auto-generated method stub
		return dao.getEventById(id);
	}

	public void removeEvent(int id) {
		// TODO Auto-generated method stub
		dao.removeEvent(id);
	}

	public Event assignSpeaker(int sid, int eid) {
		// TODO Auto-generated method stub
		return dao.assignSpeaker(sid, eid);
	}

}
