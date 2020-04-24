package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer>
{
	public Iterable<Project> findByProjectName(String name);
	
	public Iterable<Project> findByProjectDesc(String desc);
	
	public Iterable<Project> findByProjectNameAndProjectDesc(String name,String desc);
	
	public void deleteByProjectName(String name);
}
