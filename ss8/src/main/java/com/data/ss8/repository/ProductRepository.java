package com.data.ss8.repository;

import com.data.ss8.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
