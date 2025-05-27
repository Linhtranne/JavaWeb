package com.data.ss12.repository;

import com.data.ss12.model.Product;

import java.util.List;

public interface ProductRepository {
    boolean addProduct(Product product);
    Product getProductById(int id);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> getAllProducts();
    List<Product> searchProducts(String productName);
}
