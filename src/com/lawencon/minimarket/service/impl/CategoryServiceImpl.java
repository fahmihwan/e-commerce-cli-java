package com.lawencon.minimarket.service.impl;

import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public Category create(int id, String category) {
		Category createCategory = new Category();
		 createCategory.setId(id);
		 createCategory.setName(category);
		 return createCategory;
	}	
		
}
