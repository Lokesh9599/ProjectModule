package com.loki.productservice.services;

import com.loki.productservice.DTOs.FakestoreProductDTOs;
import com.loki.productservice.models.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("fake-store")
public class FakeStoreProductService implements ProductService{

    private RestTemplate r;

    public FakeStoreProductService(RestTemplate r){
        this.r=r;
    }

    @Override
    public Optional<product> getSingleProduct(Long id){
        FakestoreProductDTOs f = r.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakestoreProductDTOs.class);
        return Optional.ofNullable(f.toProduct());
    }

    @Override
    public product createProduct(String title, String description, String image, String category,double price){

        FakestoreProductDTOs fd = new FakestoreProductDTOs();
        fd.setCategory(category);
        fd.setTitle(title);
        fd.setPrice(price);
        fd.setImage(image);
        fd.setDescription(description);
        FakestoreProductDTOs f = r.postForObject(
                "https://fakestoreapi.com/products",
                        fd,FakestoreProductDTOs.class);

        return f.toProduct();
    }

    public List<product> getAllProducts(){
        FakestoreProductDTOs[] f = r.getForObject(
                "https://fakestoreapi.com/products",
                FakestoreProductDTOs[].class);

        List<product> pr = new ArrayList<>();
        for(FakestoreProductDTOs i:f){
            pr.add(i.toProduct());
        }
        return pr;
    }
}
