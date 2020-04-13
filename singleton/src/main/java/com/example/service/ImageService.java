package com.example.service;

public interface ImageService {


	public void create(String imageId,String imageUrl,boolean isAvailable);
	
	public void getImage();
	
	public void update(String oldurl,String newurl);
	
	public void delete(String url);
}
