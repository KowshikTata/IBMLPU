package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.User;
import com.example.demo.rest.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	public User findUser(int id) {
		if (dao.findById(id).isPresent()) {
			User user = dao.findById(id).get();
			return user;
		} else
			return null;
	}
	
	
}
