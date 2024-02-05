package com.example.inventory.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.model.Category;
import com.example.inventory.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/categories")
	public ArrayList<Category> getCategories() {
		return categoryService.getCategories();
	}

	@GetMapping("/categories/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") int id) {
		return categoryService.getCategoryById(id);
	}

	@PostMapping("/categories")
	public Category postCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@PutMapping("/categories/{categoryId}")
	public Category updateCategory(@PathVariable("categoryId") int id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("/categories/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") int id) {
		categoryService.deleteCategoryById(id);
	}

}
