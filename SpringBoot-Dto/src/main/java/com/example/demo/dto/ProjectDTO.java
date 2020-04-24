package com.example.demo.dto;

public class ProjectDTO {

	private String name;
	 private String desc;
	 private String agentName;
	 
	 
	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectDTO(String name, String desc, String agentName) {
		super();
		this.name = name;
		this.desc = desc;
		this.agentName = agentName;
	}
	
	public ProjectDTO(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	@Override
	public String toString() {
		return "ProjectDTO [name=" + name + ", desc=" + desc + ", agentName=" + agentName + "]";
	}
	 
	 
	 
}
