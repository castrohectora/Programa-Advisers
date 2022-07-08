package com.hectorcastro.demoadviser.service;

import com.hectorcastro.demoadviser.entity.Category;
import com.hectorcastro.demoadviser.entity.Product;
import com.hectorcastro.demoadviser.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(LocalDate.now());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct(product.getId());
        if (Objects.isNull(productDB)){
            return null;
        }
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setCategory(product.getCategory());
        productDB.setPrice(product.getPrice());

        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(String id) {
        Product productDB = getProduct(id);
        if (Objects.isNull(productDB)) {
            return null;
        }
        productDB.setStatus("DELETED");

        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(String id, Double quantity) {
        Product productDB = getProduct(id);
        if (Objects.isNull(productDB)) {
            return null;
        }
        Double stock =  productDB.getStock() + quantity;
        productDB.setStock(stock);

        return productRepository.save(productDB);
    }
}