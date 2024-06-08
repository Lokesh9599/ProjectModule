package com.loki.productservice.services;

import com.loki.productservice.models.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Optional<product> getSingleProduct(Long id);

    public product createProduct(String title, String description, String image, String category, double price);

    public List<product> getAllProducts();
}
