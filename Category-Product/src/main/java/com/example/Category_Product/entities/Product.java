package com.example.Category_Product.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Integer productId;
    private String productName;
    private Double productPrice;
    @ManyToOne
    @JoinColumn(name="categoryId",nullable = false)
    private Category category;
}
