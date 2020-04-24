package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="project_name")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String projectName;
	private String projectdesc;
	private String agentName;
	public Project(String projectName, String projectdesc, String agentName) {
		super();
		this.projectName = projectName;
		this.projectdesc = projectdesc;
		this.agentName = agentName;
	}
	
	
	public Project(String projectName, String projectdesc) {
		super();
		this.projectName = projectName;
		this.projectdesc = projectdesc;
	}


	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectdesc() {
		return projectdesc;
	}
	public void setProjectdesc(String projectdesc) {
		this.projectdesc = projectdesc;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectdesc=" + projectdesc + ", agentName="
				+ agentName + "]";
	}

}
