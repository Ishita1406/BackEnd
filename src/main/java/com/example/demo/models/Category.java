package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
}
