package com.example.dto;

import com.example.model.Category;

import lombok.Data;

@Data	
public class ProductDto {
	    
		int productId;
		String productName;
		int productPrice;
		String imgPath;
		Category category;

}
