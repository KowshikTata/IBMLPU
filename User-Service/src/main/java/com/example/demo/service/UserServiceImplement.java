package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserServiceImplement implements UserService {


	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(Integer id) {
		
		try {
			return userDao.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
