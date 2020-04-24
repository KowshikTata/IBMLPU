package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model class for Project")
public class ProjectDTO {
	@ApiModelProperty(notes = "Field for project name")
	private String name;
	@ApiModelProperty(notes = "Field for project desc")
	 private String desc;
	@ApiModelProperty(notes = "Field for gent name assigned with project")
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
