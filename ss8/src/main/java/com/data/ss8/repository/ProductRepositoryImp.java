package com.data.ss8.repository;

import com.data.ss8.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Arrays.asList(
                new Product(1, "Laptop", 1500),
                new Product(2, "Smartphone", 800),
                new Product(3, "Tablet", 500)
        );
    }
}
