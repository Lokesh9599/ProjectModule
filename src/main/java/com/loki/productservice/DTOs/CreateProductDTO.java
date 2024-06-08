package com.loki.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDTO {

    private String title;

    private String description;

    private String image;

    private String category;

    private double price;
}
