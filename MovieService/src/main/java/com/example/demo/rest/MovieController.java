package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {

	private MovieService service;

	public MovieController(MovieService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping("/movies")
	public List<Movie> getAll()
	{
		return service.getAll();
	}
	
	@RequestMapping("/movie/{id}")
	public Movie getAll(@PathVariable("id") Integer id)
	{
		return service.getById(id);
	}
	@PutMapping("/movie")
	public Movie update(@RequestBody Movie movie)
	{
		return service.update(movie);
	}
	@DeleteMapping("/movie/{id}")
	public Movie del(@PathVariable("id") Integer id)
	{
		return service.delete(id);
	}
	@PostMapping("/movie")
	public Movie save(@RequestBody Movie movie)
	{
		return service.save(movie);
	}
	
	
	
	
}
