package com.example.Category_Product.serviceImpl;

import com.example.Category_Product.entities.Category;
import com.example.Category_Product.entities.Product;
import com.example.Category_Product.exception.custom.NoSuchCategoryExist;
import com.example.Category_Product.exception.custom.NoSuchProductExist;
import com.example.Category_Product.repository.CategoryRepository;
import com.example.Category_Product.repository.ProductRepository;
import com.example.Category_Product.service.CategoryService;
import com.example.Category_Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public ResponseEntity<?> addProduct(Product product) {
                Optional<Category> category = categoryRepository.findById(product.getCategory().getCategoryId());
                if(category.isEmpty())
                {
                    throw new NoSuchCategoryExist("No such category exist", HttpStatus.NOT_FOUND);
                }
        product.setCategory(category.get());
        Product p=productRepository.save(product);
        return ResponseEntity.ok(p);
    }

    @Override
    public ResponseEntity<?> deleteProduct(Integer productId) {
        Optional<Product> productOptional=productRepository.findById(productId);
        if(productOptional.isEmpty())
        {
            throw new NoSuchProductExist("No such product exist for this id",HttpStatus.NOT_FOUND);
        }
        productRepository.deleteById(productId);
        return ResponseEntity.ok("Product successfully deleted");
    }

    @Override
    public ResponseEntity<?> getProduct() {
        List<Product> getData=productRepository.findAll();
       return ResponseEntity.ok(getData);

    }

    @Override
    public ResponseEntity<?> getProductById(Integer productId) {
        Optional<Product> productsById=productRepository.findById(productId);
        if(productsById.isPresent())
        {
            return ResponseEntity.ok(productsById);
        }
        throw new NoSuchProductExist("No product exist by this id",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> editProduct(Product product, Integer productId) {
        Optional<Product> editProducts=productRepository.findById(productId);
        if(editProducts.isEmpty())
        {
            throw new NoSuchProductExist("No product exist for this id",HttpStatus.NOT_FOUND);
        }
        Product p=editProducts.get();
        p.setProductName(product.getProductName());
        p.setProductPrice(product.getProductPrice());
        productRepository.save(p);
        return ResponseEntity.ok(p);
    }

    @Override
    public ResponseEntity<?> getProductPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        List<Product> productList = productPage.getContent();
        return ResponseEntity.ok(productList);
    }
}
