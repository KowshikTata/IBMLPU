package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Speaker;

public interface SpeakerDAO {

	
	public Speaker createSpeaker(Speaker speaker);
	
	public List<Speaker> getSpeakers();
	
	public Speaker getSpeakerById(int id);
	
	public void removeSpeaker(int id);
	
} 
