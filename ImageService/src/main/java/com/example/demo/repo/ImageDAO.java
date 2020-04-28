package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Image;

public interface ImageDAO extends CrudRepository<Image, Integer>{

}
