package com.example.demo.repo;



import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Movie;

public interface MovieDAO extends CrudRepository<Movie, Integer>{

}
