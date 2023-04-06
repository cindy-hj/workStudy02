package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDto;
import com.example.model.Category;
import com.example.model.Product;
import com.example.service.ProductService;

import lombok.Data;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// create
	@PostMapping("/api/add/product")
	public ResponseEntity<Product> addProduct(@RequestBody Map<String, String> params) {
		String productName = params.get("productName");
		String productPrice = params.get("productPrice");
		String imgPath = params.get("imgPath");
		String id = params.get("id");
				
		Product addproduct = new Product();
		addproduct.setProductName(productName);
		addproduct.setProductPrice(Integer.parseInt(productPrice));
		addproduct.setImgPath(imgPath);
		
		Category addCategory = new Category();
		addCategory.setCategoryId(Integer.parseInt(id));
		addproduct.setCategory(addCategory);
		
		Product rProduct = productService.save(addproduct);
		return new ResponseEntity<>(rProduct, HttpStatus.OK);
	}
	
	// read
	@GetMapping("/api/get/product")
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> products = productService.findAll();
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	// update
	@PutMapping("/api/modified/product")
	public ResponseEntity modifiedProduct(@RequestBody Map<String, String> params) {
	
		Product addProduct = new Product();
		addProduct.setProductId(Integer.parseInt(params.get("productId")));
		addProduct.setProductName(params.get("productName"));
		addProduct.setProductPrice(Integer.parseInt(params.get("productPrice")));
		addProduct.setImgPath(params.get("imgPath"));
		

		Category addCategory = new Category();
		addCategory.setCategoryId(Integer.parseInt(params.get("id")));
		addProduct.setCategory(addCategory);
		
		Product rProduct = productService.save(addProduct);
		
		ProductDto dto = new ProductDto();
		dto.setProductId(rProduct.getProductId());
		dto.setProductName(rProduct.getProductName());
		dto.setProductPrice(rProduct.getProductPrice());
		dto.setImgPath(rProduct.getImgPath());
		dto.setCategory(rProduct.getCategory());

		
		return new ResponseEntity<>(rProduct,HttpStatus.OK);
	}
	
	
	// update
	@PutMapping("/api/modified2/product")
	public ResponseEntity<ProductDto> modified2Product(@RequestBody Map<String, String> params) {
		int  productId = Integer.parseInt(params.get("productId"));
		String productName = params.get("productName");
		int productPrice = Integer.parseInt(params.get("productPrice"));
		String imgPath = params.get("imgPath");
		
		Product rProduct = productService.update(productId, productName, productPrice, imgPath);
		
		ProductDto dto = new ProductDto();
		dto.setProductId(rProduct.getProductId());
		dto.setProductName(rProduct.getProductName());
		dto.setProductPrice(rProduct.getProductPrice());
		dto.setImgPath(rProduct.getImgPath());
		dto.setCategory(rProduct.getCategory());
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/api/delete/product/{id}")
	public ResponseEntity deleteProduct(@PathVariable Integer id) {
		productService.deleteByProductId(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
