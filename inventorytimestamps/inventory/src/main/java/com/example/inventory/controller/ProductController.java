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
import com.example.inventory.model.Product;
import com.example.inventory.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public ArrayList<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable("productId") int id) {
		Product product = productService.getProductById(id);
		System.out.println(product.getCreatedAt());
		return product;
	}

	@PostMapping("/products")
	public Product postProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping("/products/{productId}")
	public Product updateProduct(@PathVariable("productId") int id, @RequestBody Product product) {

		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int id) {
		productService.deleteProductById(id);
	}

	@GetMapping("/products/{productId}/category")
	public Category getCategory(@PathVariable("productId") int id) {
		return productService.getCategoryByProductId(id);
	}
}
