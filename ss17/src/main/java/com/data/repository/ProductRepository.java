package com.data.repository;

import com.data.entity.Product;
import java.util.List;

public interface ProductRepository {
    void save(Product product);
    List<Product> findAllWithPagination(int start, int limit);
    long getTotalProducts();
    Product findById(int id);
}