package com.turnrut.dao;

import java.util.List;

import com.turnrut.domain.Category;

public interface CategoryDao {

	void save(Category category);

	Category getCategoryById(String id);

	List<Category> getAllCategorys();

	void removeCategoryById(String id);

}
