package com.example.inventory.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.inventory.model.Category;
import com.example.inventory.model.Product;
import com.example.inventory.repository.CategoryJpaRepository;
import com.example.inventory.repository.CategoryRepository;
import com.example.inventory.repository.ProductJpaRepository;

@Service
public class CategoryService implements CategoryRepository {

	@Autowired
	CategoryJpaRepository categoryJpaRepository;
	@Autowired
	ProductJpaRepository productJpaRepository;

	@Override
	public ArrayList<Category> getCategories() {
		return (ArrayList<Category>) categoryJpaRepository.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		try {
			Category category = categoryJpaRepository.findById(id).get();
			return category;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Category addCategory(Category category) {
		categoryJpaRepository.save(category);
		return category;
	}

	@Override
	public Category updateCategory(int id, Category category) {
		try {
			Category orginal = categoryJpaRepository.findById(id).get();
			if (category.getCategoryName() != null) {
				orginal.setCategoryName(category.getCategoryName());
			}
			categoryJpaRepository.save(orginal);

			return orginal;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteCategoryById(int id) {
		try {
			Category category = categoryJpaRepository.findById(id).get();
			ArrayList<Product> products = productJpaRepository.findByCategory(category);
			for (Product product : products) {
				productJpaRepository.deleteById(product.getProductId());
			}
			categoryJpaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
