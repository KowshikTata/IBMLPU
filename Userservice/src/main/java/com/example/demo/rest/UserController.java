package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("/movies")
	public List getAll()
	{
		return service.getAll();
	}
	
	@RequestMapping("/movie/{id}")
	public Object getAll(@PathVariable("id") Integer id)
	{
		return service.findById(id);
	}
	@PutMapping("/movie")
	public Object update(@RequestBody Object object)
	{
		return service.update(object);
	}
	@DeleteMapping("/movie/{id}")
	public Object del(@PathVariable("id") Integer id)
	{
		return service.delete(id);
	}
	@PostMapping("/movie")
	public Object save(@RequestBody Object object)
	{
		return service.save(object);
	}
}
