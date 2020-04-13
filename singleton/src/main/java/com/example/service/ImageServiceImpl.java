package com.example.service;

import com.example.Dao.ImageDao;
import com.example.Dao.ImageDaoImpl;

public class ImageServiceImpl implements ImageService{
	
	ImageDao dao=new ImageDaoImpl();

	public void create(String imageId, String imageUrl, boolean isAvailable) {
		// TODO Auto-generated method stub
		dao.create(imageId, imageUrl, isAvailable);
	}

	public void getImage() {
		// TODO Auto-generated method stub
		dao.getImage();
	}

	public void update(String oldurl, String newurl) {
		// TODO Auto-generated method stub
		dao.update(oldurl, newurl);
	}

	public void delete(String url) {
		// TODO Auto-generated method stub
		dao.delete(url);
	}

}
