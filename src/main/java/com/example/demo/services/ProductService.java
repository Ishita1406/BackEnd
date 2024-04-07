package com.example.demo.services;

import com.example.demo.models.Product;

import java.util.List;


public interface ProductService {
    Product getProductByid(Long id);

    List<Product> getAllProducts();
}
