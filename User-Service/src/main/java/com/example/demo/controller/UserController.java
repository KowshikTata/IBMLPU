

package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.exception.UserNotFoundException;
import com.example.demo.controller.exception.UserResponseEntity;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("users/{id}")
	public User getUserById(@PathVariable Integer id) throws UserNotFoundException
	{
		System.out.println("before");
		User user = userService.getUserById(id);
		System.out.println("After");
		 if(user==null)
		 {
			 throw new UserNotFoundException("User id -- "+id+" not allowed to see the movie list ");
			 
		 }
		return userService.getUserById(id);
		 
		 
			 
	}
	
	@ExceptionHandler
	public ResponseEntity<UserResponseEntity> handleException(UserNotFoundException snfe)
	{
		return new ResponseEntity<UserResponseEntity>(new UserResponseEntity(HttpStatus.NOT_FOUND.value(),
				snfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	
}
