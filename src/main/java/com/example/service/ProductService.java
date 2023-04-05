package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.model.Product;

public interface ProductService {

	Product save(Product product);

}
