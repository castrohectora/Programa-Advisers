package com.hectorcastro.demoadviser.repository;

import com.hectorcastro.demoadviser.entity.Category;
import com.hectorcastro.demoadviser.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByCategory(Category category);
}
