package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Image;
import com.example.demo.repo.ImageDAO;
@Service
public class ImageServiceImpl implements ImageService{

	private ImageDAO dao;
	
	
	public ImageServiceImpl(ImageDAO dao) {
		super();
		this.dao = dao;
	}


	@Override
	public List<Image> getAll() {
		// TODO Auto-generated method stub
		return (List<Image>) dao.findAll();
	}

}
