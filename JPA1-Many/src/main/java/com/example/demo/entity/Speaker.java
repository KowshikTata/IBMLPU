package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="speaker")
public class Speaker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String email;
	
	private Boolean isAvailable;
	@OneToMany(mappedBy = "speaker", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Event> events;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Speaker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Speaker(String name, String email, Boolean isAvailable) {
		
		this.name = name;
		this.email = email;
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Speaker [id=" + id + ", name=" + name + ", email=" + email + ", isAvailable=" + isAvailable + "]";
	}
	public void add(Event tempEvent) {

		if (events == null) {
			events = new ArrayList<Event>();
		}

		events.add(tempEvent);

		tempEvent.setSpeaker(this);
	}
	
	
	
}
