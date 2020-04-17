package com.example.demo.entity;




import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String eventname;
	@Temporal(value =TemporalType.DATE)
	private Date date;
	
	private int duration;
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="speaker_id")
	private Speaker speaker;
	
	public int getId() {
		return id;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration ) {
		this.duration = duration;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventname=" + eventname + ", date=" + date + ", duration=" + duration + ", speaker="
				+ speaker + "]";
	}
	public Event(String eventname, Date date, int duration) {
		super();
		this.eventname = eventname;
		this.date = date;
		this.duration=duration;
		
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
}
