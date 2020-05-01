package com.example.demo.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/users/{userID}")
	public int getUser(@PathVariable int userID){
		User user = service.findUser(userID);
		if(user==null)
			return 0;
		else
			return 1;
	}
	
	
	
}
