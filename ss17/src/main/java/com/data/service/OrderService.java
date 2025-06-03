package com.data.service;

import com.data.entity.Order;
import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    List<Order> getOrdersByCustomerId(int customerId, int page, int size);
    Order getOrderById(int id);
    void deleteOrder(Order order);
    int getTotalOrdersByCustomerId(int customerId);
}