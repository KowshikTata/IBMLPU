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
	private String projectDesc;
	private String agentName;
	public Project(String projectName, String projectDesc, String agentName) {
		super();
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.agentName = agentName;
	}
	
	
	public Project(String projectName, String projectDesc) {
		super();
		this.projectName = projectName;
		this.projectDesc = projectDesc;
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
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectdesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectDesc=" + projectDesc + ", agentName="
				+ agentName + "]";
	}

}
