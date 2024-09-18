package com.example.Category_Product.serviceImpl;

import com.example.Category_Product.entities.Category;
import com.example.Category_Product.exception.custom.NoSuchCategoryExist;
import com.example.Category_Product.repository.CategoryRepository;
import com.example.Category_Product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public ResponseEntity<?> addCategory(Category category) {
        Category c=categoryRepository.save(category);
        return ResponseEntity.ok(c);
    }

    @Override
    public ResponseEntity deleteCategory(Integer categoryId) {
        //Optional<Category> c= Optional.ofNullable(categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found")));
       Optional <Category> c=categoryRepository.findById(categoryId);
       if(c.isPresent()) {
           categoryRepository.deleteById(categoryId);
           return ResponseEntity.ok("Category successfully deleted");
       }
       throw new NoSuchCategoryExist("No such category exist for this id",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> updateCategory(Category category, Integer categoryId) {
        Optional<Category> editCategory=categoryRepository.findById(categoryId);
        if(editCategory.isPresent()) {
            Category c = editCategory.get();
            c.setCategoryName(category.getCategoryName());
            categoryRepository.save(c);
            return ResponseEntity.ok(c);
        }
        throw new NoSuchCategoryExist("No such data exist for this id",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> getCategory() {
        List<Category> ll=categoryRepository.findAll();
       return ResponseEntity.ok(ll);
    }

    @Override
    public ResponseEntity<?> getById(Integer categoryId) {
        Optional<Category> detail=categoryRepository.findById(categoryId);
       if(detail.isEmpty())
       {
           throw new NoSuchCategoryExist("No such category exist with id",HttpStatus.NOT_FOUND);
       }
        return ResponseEntity.ok(detail);
    }


//    public ResponseEntity<List<Category>> getCategoryPagination(int page, int size) {
//        Pageable p= PageRequest.of(page,size);
//        List<Category> categoryList=categoryRepository.findAll();
//        return ResponseEntity.ok(categoryList);
//    }
    @Override
    public ResponseEntity<List<Category>> getCategoryPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categoryPage = categoryRepository.findAll(pageable);

        List<Category> categoryList = categoryPage.getContent();
        return ResponseEntity.ok(categoryList);
    }

}
