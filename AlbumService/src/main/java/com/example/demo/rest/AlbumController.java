package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AlbumService;

@RestController
public class AlbumController {

	@Autowired
	private AlbumService service;
	
	@RequestMapping("/images")
	public List get()
	{
		return service.getAll();
	}
}
