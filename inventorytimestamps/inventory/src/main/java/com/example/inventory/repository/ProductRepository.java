package com.example.inventory.repository;

import java.util.ArrayList;

import com.example.inventory.model.Category;
import com.example.inventory.model.Product;

public interface ProductRepository {
	ArrayList<Product> getProducts();

	Product getProductById(int id);

	Product addProduct(Product product);

	Product updateProduct(int id, Product product);

	void deleteProductById(int id);

	Category getCategoryByProductId(int id);
}
