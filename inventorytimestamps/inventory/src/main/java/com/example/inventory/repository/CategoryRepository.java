package com.example.inventory.repository;

import java.util.ArrayList;

import com.example.inventory.model.Category;

public interface CategoryRepository {

	ArrayList<Category> getCategories();

	Category getCategoryById(int id);

	Category addCategory(Category category);

	Category updateCategory(int id, Category category);

	void deleteCategoryById(int id);
}
