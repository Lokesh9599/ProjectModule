package com.loki.productservice.services;

import com.loki.productservice.models.Category;
import com.loki.productservice.models.product;
import com.loki.productservice.repositories.CategoryRepo;
import com.loki.productservice.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("self-store")
public class SelfProductService implements ProductService{

    private ProductRepo PR;
    private CategoryRepo CR;

    public SelfProductService(ProductRepo PR, CategoryRepo CR){
        this.PR=PR;
        this.CR=CR;
    }
    @Override
    public Optional<product> getSingleProduct(Long id) {
        return PR.findById(id);
    }

    @Override
    public product createProduct(String title, String description, String image, String categoryTitle, double price) {

        product product = new product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageURL(image);
         product.setPrice(price);

        Category categoryFromDatabase= CR.findByTitle(categoryTitle);
        if(categoryFromDatabase == null){
            Category newCategory = new Category();
            newCategory.setTitle(categoryTitle);
            categoryFromDatabase = CR.save(new Category());
        }
        product.setCategory(categoryFromDatabase);
        return PR.save(product);
    }

    @Override
    public List<product> getAllProducts() {
        return PR.findAll();
    }
}
