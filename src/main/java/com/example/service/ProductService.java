package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> findAll();

	Product update(int productId, String productName, int productPrice, String imgPath);

	void deleteByProductId(Integer id);

}
