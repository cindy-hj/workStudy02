package com.example.service;

import java.util.List;

import com.example.model.Category;

public interface CategoryService {

	Category save(Category addCategory);

	List<Category> findAll();

	void deleteByCategoryId(int categoryId);

}
