package com.hectorcastro.demoadviser.controller;

import com.hectorcastro.demoadviser.entity.Category;
import com.hectorcastro.demoadviser.entity.Product;
import com.hectorcastro.demoadviser.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(
            @RequestParam(name = "categoryId", required = false) Long categoryId) {
        List<Product> products = new ArrayList<>();

        if (Objects.isNull(categoryId)) {
            products = productService.listAllProduct();

            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            products = productService.findByCategory(Category.builder().id(categoryId).build());

            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") String productId) {
        Product product = productService.getProduct(productId);

        if (Objects.isNull(product)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        product.setId(id);
        Product productDB =  productService.updateProduct(product);

        if (Objects.isNull(productDB)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String id){
        Product productDelete = productService.deleteProduct(id);

        if (Objects.isNull(productDelete)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productDelete);
    }

    @PutMapping (value = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable String id ,@RequestParam(name = "quantity", required = true) Double quantity){
        Product product = productService.updateStock(id, quantity);

        if (Objects.isNull(product)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }
}
