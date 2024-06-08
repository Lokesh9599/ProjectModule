package com.loki.productservice.repositories;

import com.loki.productservice.models.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<product, Long> {

    @Override
    product save(product entity);

    Optional<product> findById(Long id);

    @Override
    List<product> findAll();
}
