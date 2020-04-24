package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;

public interface ProjectService {

	public ProjectDTO get(int id);
	
	public List<ProjectDTO> getAll();
	
	public ProjectDTO save(ProjectDTO projectdto);
	
	public ProjectDTO del(int id);
	
	public ProjectDTO update(Project project);
	
}
