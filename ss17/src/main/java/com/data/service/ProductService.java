package com.data.service;

import com.data.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAllWithPagination(int page, int size);
    long getTotalProducts();
    Product findById(int id);
}