package com.loki.productservice.controller;

import com.loki.productservice.DTOs.CreateProductDTO;
import com.loki.productservice.models.product;
import com.loki.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    ProductService ps;

    public ProductController(@Qualifier("self-store") ProductService ps){
        this.ps=ps;
    }

    @PostMapping("/products")
    public product createProduct(@RequestBody CreateProductDTO proreqDTO ){
        return ps.createProduct(
                proreqDTO.getTitle(),
                proreqDTO.getCategory(),
                proreqDTO.getImage(),
                proreqDTO.getDescription(),
                proreqDTO.getPrice()
        );
    }

    @GetMapping("/products")
    public List<product> getAllProducts(){
        return ps.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<product> getProductById(@PathVariable("id") Long id){
        product p = new product();
        p.getId();
        p.setTitle("abcd");
        return ps.getSingleProduct(id);
    }

    public void deleteProduct(Long id){

    }
}
