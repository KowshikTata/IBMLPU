package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SchoolService;

@RestController
public class SchoolController {
	
	private SchoolService service;

	public SchoolController(SchoolService service) {
		super();
		this.service = service;
	}

	@RequestMapping("/getStudent")
	public List get(@PathVariable("name") String name)
	{
		return service.get(name);
	}
	
}
