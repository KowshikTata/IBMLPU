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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/api")
@Api(value="Project Management System", description="Operations pertaining to projects")
public class ProjectController {

	private ProjectService service;
	@Autowired
	public ProjectController(ProjectService service) {
		super();
		this.service = service;
	}
	@ApiOperation(value = "View a list of available projects", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/projects")
	public List<ProjectDTO> getAll()
	{
		return service.getAll();
	}
	@ApiOperation(value = "View a particular available projects", response = List.class)
	@GetMapping("/projects/{id}")
	public ProjectDTO get(@PathVariable("id") int id)
	{
		return service.get(id);
	}
	@ApiOperation(value = "Craete  projects", response = List.class)
	@PostMapping("/projects")
	public ProjectDTO create(@RequestBody ProjectDTO dto)
	{
		
		return service.save(dto);
	}
	@ApiOperation(value = "Remove available projects", response = List.class)
	@DeleteMapping("/projects/{id}")
	public ProjectDTO del(@PathVariable("id") int id)
	{
		return service.del(id);
	}
	@ApiOperation(value = "Updation of available projects", response = List.class)
	@PutMapping("/projects")
	public ProjectDTO update(@RequestBody Project project)
	{
		
		return service.update(project);
	}
	@GetMapping("/projects/name/{name}")
	public Iterable<ProjectDTO> getByName(@PathVariable("name") String name)
	{
		return service.findByprojectName(name);
	}
	@GetMapping("/projects/desc/{desc}")
	public Iterable<ProjectDTO> getAl(@PathVariable("desc") String desc)
	{
		return service.findByprojectdesc(desc);
	}
	@GetMapping("/projects/{name}/{desc}")
	public Iterable<ProjectDTO> getl(@PathVariable("name") String name,@PathVariable("desc") String desc)
	{
		return service.findByprojectNameAndprojectdesc(name, desc);
	}
	@DeleteMapping("/projects/name/{name}")
	public void del2(@PathVariable("name") String name)
	{
		service.deleteByProjectName(name);
	}
}
