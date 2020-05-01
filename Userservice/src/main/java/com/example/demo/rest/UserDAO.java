package com.example.demo.rest;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserDAO extends CrudRepository<User, Integer> {

}
