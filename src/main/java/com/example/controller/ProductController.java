package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// create
	@PostMapping("/api/add/product")
	public ResponseEntity addProduct(@RequestBody Map<String, String> params) {
		String productName = params.get("productName");
		String productPrice = params.get("productPrice");
		String imgPath = params.get("imgPath");
		
		Product addproduct = new Product();
		addproduct.setProductName(productName);
		addproduct.setProductPrice(Integer.parseInt(productPrice));
		addproduct.setImgPath(imgPath);
		
		Product rProduct = productService.save(addproduct);
		return new ResponseEntity<>(rProduct, HttpStatus.OK);
	}
	
}
