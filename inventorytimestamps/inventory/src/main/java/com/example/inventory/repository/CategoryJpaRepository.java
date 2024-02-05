package com.example.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.model.Category;

@Repository
public interface CategoryJpaRepository extends CrudRepository<Category, Integer> {

}
