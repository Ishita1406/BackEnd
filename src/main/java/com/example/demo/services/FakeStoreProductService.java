package com.example.demo.services;

import com.example.demo.dtos.FakeStoreProductDto;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
//you can use component instead of service

public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductByid(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            return null;
        }
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos) {
            products.add(convertFakeStoreDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }
    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);
        return product;
    }
}
