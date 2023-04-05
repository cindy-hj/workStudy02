package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Category;
import com.example.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/api/add/category")
	public ResponseEntity addCategory(@RequestBody Map<String, String> params) {
		String categoryName = params.get("categoryName");
		
		Category addCategory = new Category();
		addCategory.setCategoryName(categoryName);
		
		Category resultCategory = categoryService.save(addCategory);
	
		return new ResponseEntity<>(resultCategory, HttpStatus.OK);
	}
	
	@GetMapping("/api/get/category")
	public ResponseEntity getCategory() {
		List<Category> categorys = categoryService.findAll();
		
		return new ResponseEntity<>(categorys, HttpStatus.OK);
	}
	
	@PutMapping("/api/modified/category")
	public ResponseEntity modifiedCategory(@RequestBody Map<String, String> params) {
		int categoryId = Integer.parseInt(params.get("categoryId"));
		String categoryName = params.get("categoryName");
		
		Category modifiedCategory = new Category();
		modifiedCategory.setCategoryId(categoryId);
		modifiedCategory.setCategoryName(categoryName);
		
		Category resultCategory = categoryService.save(modifiedCategory);
		
		return new ResponseEntity<>(resultCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/delete/category/{id}")
	public ResponseEntity deleteCategory(@PathVariable int id) {
		int categoryId = id;
		
		categoryService.deleteByCategoryId(categoryId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
