package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	private ProductService service;

	
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}


	@RequestMapping("/products")
    public String getAll(Model model){

        model.addAttribute("products", service.getAll());

        return "products";
    }
}
