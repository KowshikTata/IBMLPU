package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EventDAO;
import com.example.demo.dao.SpeakerDAO;
import com.example.demo.entity.Speaker;
@Service("SpeakerServiceImpl")
public class SpeakerServiceImpl implements SpeakerService {

	SpeakerDAO dao;
	
	@Autowired
	public  SpeakerServiceImpl(SpeakerDAO dao)
	{
		super();
		this.dao=dao;
	}
	
	public Speaker createSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		return dao.createSpeaker(speaker);
	}

	public List<Speaker> getSpeakers() {
		// TODO Auto-generated method stub
		return dao.getSpeakers();
	}

	public Speaker getSpeakerById(int id) {
		// TODO Auto-generated method stub
		return dao.getSpeakerById(id);
	}

	public void removeSpeaker(int id) {
		// TODO Auto-generated method stub
		dao.removeSpeaker(id);

	}

}
