package com.data.service;

import com.data.entity.Product;
import com.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllWithPagination(int page, int size) {
        int start = page * size;
        return productRepository.findAllWithPagination(start, size);
    }

    @Override
    public long getTotalProducts() {
        return productRepository.getTotalProducts();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}