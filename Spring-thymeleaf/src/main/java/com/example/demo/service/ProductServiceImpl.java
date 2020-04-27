package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductDAO dao;

	
	
	public ProductServiceImpl(ProductDAO dao) {
		super();
		this.dao = dao;
	}



	@Override
	public Iterable<Product> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
