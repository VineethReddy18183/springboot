package com.example.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.model.Category;
import com.example.inventory.model.Product;

@Repository
public interface ProductJpaRepository extends CrudRepository<Product, Integer> {
	ArrayList<Product> findByCategory(Category category);
}
