package com.example.Category_Product.repository;

import com.example.Category_Product.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
