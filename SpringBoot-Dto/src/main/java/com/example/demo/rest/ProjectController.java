package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {

	private ProjectService service;
	@Autowired
	public ProjectController(ProjectService service) {
		super();
		this.service = service;
	}

	@GetMapping("/projects")
	public List<ProjectDTO> getAll()
	{
		return service.getAll();
	}
	@GetMapping("/projects/{id}")
	public ProjectDTO get(@PathVariable("id") int id)
	{
		return service.get(id);
	}
	@PostMapping("/projects")
	public ProjectDTO create(@RequestBody ProjectDTO dto)
	{
		
		return service.save(dto);
	}
	@DeleteMapping("/projects/{id}")
	public ProjectDTO del(@PathVariable("id") int id)
	{
		return service.del(id);
	}
	@PutMapping("/projects")
	public ProjectDTO update(@RequestBody Project project)
	{
		
		return service.update(project);
	}
	
	
}
