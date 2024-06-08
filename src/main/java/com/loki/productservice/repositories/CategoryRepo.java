package com.loki.productservice.repositories;

import com.loki.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    Category findByTitle(String title);

    Category save(Category category);
}
