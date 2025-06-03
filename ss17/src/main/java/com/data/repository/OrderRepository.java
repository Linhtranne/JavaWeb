package com.data.repository;

import com.data.entity.Order;
import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findByCustomerId(int customerId, int page, int size);
    Order findById(int id);
    void delete(Order order);
    int countByCustomerId(int customerId);
}