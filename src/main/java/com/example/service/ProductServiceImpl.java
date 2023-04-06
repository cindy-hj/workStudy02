package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional
	@Override
	public Product update(int productId, String productName, int productPrice, String imgPath) {
		Product readProduct = productRepository.findByProductId(productId);
		
		readProduct.update(productId, productName, productPrice, imgPath);
		
		return readProduct;
	}

	@Transactional
	@Override
	public void deleteByProductId(Integer id) {
		productRepository.deleteByProductId(id);
	}
	
	// create
	
	
	// read
	
	
	// update
	
	
	// delete
	
}
