package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Image;
import com.example.demo.service.ImageService;

@RestController
public class ImageController {
	
	private ImageService service;

	
	
	public ImageController(ImageService service) {
		super();
		this.service = service;
	}



	@RequestMapping("/images")
	public List<Image> getAll()
	{
		return service.getAll();
	}
	
}
