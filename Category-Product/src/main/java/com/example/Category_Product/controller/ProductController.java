package com.example.Category_Product.controller;

import com.example.Category_Product.entities.Category;
import com.example.Category_Product.entities.Product;
import com.example.Category_Product.repository.CategoryRepository;
import com.example.Category_Product.repository.ProductRepository;
import com.example.Category_Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        return this.productService.addProduct(product);
    }
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId)
    {
        return this.productService.deleteProduct(productId);
    }
    @GetMapping("/getProducts")
    public ResponseEntity<?> getProduct()
    {
       return this.productService.getProduct();
    }
    @GetMapping("/get/product/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId)
    {
        return this.productService.getProductById(productId);
    }
    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer productId)
    {
        return this.productService.editProduct(product,productId);
    }
    @GetMapping("/productPagination")
    public ResponseEntity<?> getPrductPagination(@RequestParam int page,@RequestParam int size)
    {
        return this.productService.getProductPagination(page,size);
    }
}
