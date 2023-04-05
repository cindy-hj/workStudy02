package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category addCategory) {	
		return categoryRepository.save(addCategory);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Transactional
	@Override
	public void deleteByCategoryId(int categoryId) {
		categoryRepository.deleteByCategoryId(categoryId);
	}

}
