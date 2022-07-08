package com.hectorcastro.demoadviser.service;

import com.hectorcastro.demoadviser.entity.Category;
import com.hectorcastro.demoadviser.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();
    Product getProduct(String id);

    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(String id);
    List<Product> findByCategory(Category category);
    Product updateStock(String id, Double quantity);
}
