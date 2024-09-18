package com.example.Category_Product.controller;

import com.example.Category_Product.entities.Category;
import com.example.Category_Product.repository.CategoryRepository;
import com.example.Category_Product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody Category category)
    {
        return this.categoryService.addCategory(category);
    }
    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable Integer categoryId)
    {
        return this.categoryService.deleteCategory(categoryId);
    }
    @PutMapping("/updateCategory/{categoryId}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category,@PathVariable Integer categoryId)
    {
        return this.categoryService.updateCategory(category,categoryId);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getCategory()
    {
        return this.categoryService.getCategory();
    }
    @GetMapping("/get/{categoryId}")
    public ResponseEntity<?> getById(@PathVariable Integer categoryId)
    {
        return this.categoryService.getById(categoryId);
    }
    @GetMapping("/categortyPagination")
    public ResponseEntity<List<Category>> getCategoryPagination(@RequestParam int page, @RequestParam int size)
    {
       return this.categoryService.getCategoryPagination(page,size);
    }
}
