package com.example.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.exception.MovieResponseEntity;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {

	private MovieService service;

	public MovieController(MovieService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping("/movies/{userID}")
	public List<Movie> getAll(@PathVariable("userID") int userID) throws UserNotFoundException
	{
		int response = service.findUser(userID);
		if(response==0)	
		{
			throw new UserNotFoundException(" u r not authorized");
		}
		else
		{
		return service.getAll();
		}
	}
	
	@RequestMapping("/movie/{id}/{userID}")
	public Movie getAll(@PathVariable("id")  Integer id,@PathVariable("userID") Integer userID) throws MovieNotFoundException, UserNotFoundException
	{
		int response = service.findUser(userID);
		if(response==0)	
		{
			throw new UserNotFoundException(" u r not authorized");
		}
		else
		{
		Movie m=service.getById(id);
		if(m==null)
		{
			throw new MovieNotFoundException(" no movie found!!");
		}
		else
		{
			return service.getById(id);
			
		}
		}
		
	}
	
	@DeleteMapping("/movie/{id}/{userID}")
	public Movie del(@PathVariable("id")  Integer id,@PathVariable("userID") Integer userID) throws MovieNotFoundException, UserNotFoundException
	{
		int response = service.findUser(userID);
		if(response==0)	
		{
			throw new UserNotFoundException(" u r not authorized");
		}
		else
		{
		Movie m=service.getById(id);
		if(m==null)
		{
			throw new MovieNotFoundException(" no movie found!!");
		}
		else
		{
			return service.delete(id);
			
		}
		}
	}
	@PutMapping("/movie/{id}")
	public Movie update(@PathVariable("id") Integer id,@RequestBody Movie movie) throws MovieNotFoundException, UserNotFoundException
	{
		int response = service.findUser(id);
		if(response==0)	
		{
			throw new UserNotFoundException(" u r not authorized");
		}
		else
		{
		Movie m=service.getById(movie.getId());
		if(m==null)
		{
			throw new MovieNotFoundException(" no movie found!!");
		}
		else
		{
			return service.save(movie);
			
		}
		}
	}
	@PostMapping("/movie/{id}")
	public Movie save(@PathVariable("id") Integer id,@RequestBody Movie movie) throws UserNotFoundException 
	{
		int response = service.findUser(id);
		if(response==0)	
		{
			throw new UserNotFoundException(" u r not authorized");
		}
		else
		{
		return service.save(movie);
		}
	}
	@ExceptionHandler
	public ResponseEntity<MovieResponseEntity> handlemovieexception(MovieNotFoundException mnfe)
	{
		return new ResponseEntity<MovieResponseEntity>(new MovieResponseEntity(HttpStatus.NOT_FOUND.value(),mnfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
		
	}
}
