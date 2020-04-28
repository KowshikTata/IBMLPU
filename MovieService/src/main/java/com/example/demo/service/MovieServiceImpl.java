package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repo.MovieDAO;
@Service
public class MovieServiceImpl implements MovieService{
	
	private MovieDAO dao;

	public MovieServiceImpl(MovieDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Movie> getAll() {
		// TODO Auto-generated method stub
		return (List<Movie>) dao.findAll();
	}

	@Override
	public Movie getById(int id) {
	
		return dao.findById(id).get();
	}

	@Override
	public Movie delete(int id) {
		Movie m=dao.findById(id).get();
		if(m==null)
		{
		return null;
		}
		else
		{
			dao.deleteById(id);
			return m;
		}
	}

	@Override
	public Movie save(Movie movie) {
		
		return dao.save(movie);
	}

	@Override
	public Movie update(Movie movie) {
		Movie m=dao.findById(movie.getId()).get();
		if(m==null)
		{
		return null;
		}
		else
		{
		return dao.save(movie);
		}
	}

}
