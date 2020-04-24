package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import com.example.demo.repo.ProjectRepository;
@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository repo;
	@Autowired
	public ProjectServiceImpl(ProjectRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public ProjectDTO get(int id) {
		if(repo.findById(id).isPresent())
		{
			Project p=repo.findById(id).get();
			ProjectDTO dto=new ProjectDTO(p.getProjectName(),p.getProjectdesc());
		return dto;
		}else
		{
		return null;
		}
	}

	@Override
	public List<ProjectDTO> getAll() {
		List<ProjectDTO> list=new  ArrayList();
		repo.findAll().forEach(p ->{list.add(new ProjectDTO(p.getProjectName(),p.getProjectdesc() ));
		
		});
		return list;
	}

	@Override
	public ProjectDTO save(ProjectDTO projectdto) {
		Project project=new Project(projectdto.getName(),projectdto.getDesc());
		project.setAgentName("Tata");
		repo.save(project);
		return projectdto;
	}

	@Override
	public ProjectDTO del(int id) {
		if(repo.findById(id).isPresent())
		{
			
			Project p=repo.findById(id).get();
			
			ProjectDTO dto=new ProjectDTO(p.getProjectName(),p.getProjectdesc());
			repo.deleteById(id);
			return dto;
		}
		else
		{
		return null;
		}
	}

	@Override
	public ProjectDTO update(Project project) {
		if(repo.findById(project.getId()).isPresent())
		{
			 repo.save(project);
			 ProjectDTO dto=new ProjectDTO(project.getProjectName(),project.getProjectdesc());
			 return dto;
		}
		return null;
	}

	
}
