package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Movie;

public interface MovieService {

	public List<Movie> getAll();
	
	public Movie getById(int id);
	
	public Movie delete(int id);
	
	public Movie save(Movie movie);
	
	public Movie update(Movie movie);
	
	
}
