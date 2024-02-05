
package com.example.inventory.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.inventory.model.Category;
import com.example.inventory.model.Product;
import com.example.inventory.repository.CategoryJpaRepository;
import com.example.inventory.repository.ProductJpaRepository;
import com.example.inventory.repository.ProductRepository;

@Service
public class ProductService implements ProductRepository {

	@Autowired
	ProductJpaRepository productJpaRepository;
	@Autowired
	CategoryJpaRepository categoryJpaRepository;

	@Override
	public ArrayList<Product> getProducts() {
		return (ArrayList<Product>) productJpaRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		try {
			Product product = productJpaRepository.findById(id).get();
			return product;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Product addProduct(Product product) {

		try {
			int id = product.getCategory().getCategoryId();
			Category category = categoryJpaRepository.findById(id).get();
			product.setCategory(category);
			productJpaRepository.save(product);
			return product;

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Product updateProduct(int id, Product product) {
		try {
			Product orginal = productJpaRepository.findById(id).get();
			if (product.getProductName() != null) {
				orginal.setProductName(product.getProductName());
			}
			if (product.getPrice() != 0) {
				orginal.setPrice(product.getPrice());
			}
			if (product.getCategory() != null) {
				int categoryId = product.getCategory().getCategoryId();
				Category category = categoryJpaRepository.findById(categoryId).get();
				orginal.setCategory(product.getCategory());
			}
			productJpaRepository.save(orginal);

			return orginal;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteProductById(int id) {
		try {
			Product orginal = productJpaRepository.findById(id).get();
			productJpaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Category getCategoryByProductId(int id) {

		try {
			Product orginal = productJpaRepository.findById(id).get();
			return orginal.getCategory();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}