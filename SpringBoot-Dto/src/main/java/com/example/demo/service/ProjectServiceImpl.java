package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import com.example.demo.repo.ProjectRepository;
@Service
@EnableTransactionManagement
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
			ProjectDTO dto=new ProjectDTO(p.getProjectName(),p.getProjectDesc());
		return dto;
		}else
		{
		return null;
		}
	}

	@Override
	public List<ProjectDTO> getAll() {
		List<ProjectDTO> list=new  ArrayList();
		repo.findAll().forEach(p ->{list.add(new ProjectDTO(p.getProjectName(),p.getProjectDesc() ));
		
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
			
			ProjectDTO dto=new ProjectDTO(p.getProjectName(),p.getProjectDesc());
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
			 ProjectDTO dto=new ProjectDTO(project.getProjectName(),project.getProjectDesc());
			 return dto;
		}
		else
		{
		return null;
		}
	}

	@Override
	public Iterable<ProjectDTO> findByprojectName(String name) {
		
		List<ProjectDTO> list=new  ArrayList();
		repo.findByProjectName(name).forEach(p ->{list.add(new ProjectDTO(p.getProjectName(),p.getProjectDesc() ));
		
		});
		return list;
	}

	@Override
	public Iterable<ProjectDTO> findByprojectdesc(String desc) {
		List<ProjectDTO> list=new  ArrayList();
		repo.findByProjectDesc(desc).forEach(p ->{list.add(new ProjectDTO(p.getProjectName(),p.getProjectDesc() ));
		
		});
		return list;
	}

	@Override
	public Iterable<ProjectDTO> findByprojectNameAndprojectdesc(String name,String desc) {
		List<ProjectDTO> list=new  ArrayList();
		repo.findByProjectNameAndProjectDesc(name, desc).forEach(p ->{list.add(new ProjectDTO(p.getProjectName(),p.getProjectDesc() ));
		
		});
		return list;
	}

	@Override
	@Transactional
	public void deleteByProjectName(String name) {

			repo.deleteByProjectName(name);

		
	}
	
}
