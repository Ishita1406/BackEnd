package com.example.demo.controllers;

import com.example.demo.dtos.FakeStoreProductDto;
import com.example.demo.models.Product;
import com.example.demo.services.FakeStoreProductService;
import com.example.demo.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductByid(@PathVariable("id") Long id) {

        return productService.getProductByid(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
