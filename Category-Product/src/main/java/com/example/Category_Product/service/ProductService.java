package com.example.Category_Product.service;

import com.example.Category_Product.entities.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
   public ResponseEntity<?> addProduct(Product product);

   public  ResponseEntity<?> deleteProduct(Integer productId);

   public ResponseEntity<?> getProduct();

   public ResponseEntity<?> getProductById(Integer productId);

   public ResponseEntity<?> editProduct(Product product, Integer productId);

  public ResponseEntity<?> getProductPagination(int page, int size);
}
