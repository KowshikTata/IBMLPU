package com.example.demo.service;


import java.util.Optional;

import com.example.demo.model.Product;

public interface ProductService {
public Iterable<Product> getAll();

public Product getProductById(Integer id);

public Product createProduct(Product product);

public Product updateProduct(Product product);
}
