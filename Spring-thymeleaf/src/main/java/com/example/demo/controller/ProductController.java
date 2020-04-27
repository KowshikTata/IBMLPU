package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Product;
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
	@RequestMapping("/product/{id}")
    public String get(@PathVariable("id") Integer id,Model model){

        model.addAttribute("product", service.getProductById(id));

        return "product";
    }
	@RequestMapping("/product/edit/{id}")
    public String update(@PathVariable("id") Integer id,Model model){

        model.addAttribute("product", service.getProductById(id));

        return "editproduct";
	}
	@PutMapping("/product")
	public String update(Product product)
	{
		Product savedProduct = service.updateProduct(product);
        return "redirect:/products/";
	}
	@RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String createProduct(Product product){
        Product savedProduct = service.createProduct(product);
        return "redirect:/products/";
    }
	
}
