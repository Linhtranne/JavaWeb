package com.data.service;

import com.data.entity.Order;
import com.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByCustomerId(int customerId, int page, int size) {
        return orderRepository.findByCustomerId(customerId, page, size);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public int getTotalOrdersByCustomerId(int customerId) {
        return orderRepository.countByCustomerId(customerId);
    }
}