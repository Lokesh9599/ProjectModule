package com.loki.productservice.DTOs;

import com.loki.productservice.models.Category;
import com.loki.productservice.models.product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakestoreProductDTOs {

    private Long id;

    private String title;

    private String description;

    private String image;

    private String category;

    private double price;

    public product toProduct(){
        product pr = new product();
        pr.setId(getId());
        pr.setTitle(getTitle());
        pr.setDescription(getDescription());
        pr.setImageURL(getImage());

        Category c = new Category();
        c.setTitle(getTitle());
        pr.setCategory(c);
        return pr;
    }
}
