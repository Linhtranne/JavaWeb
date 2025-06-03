package com.data.repository;

import com.data.entity.CartItem;
import com.data.entity.Customer;
import java.util.List;

public interface CartItemRepository {
    void save(CartItem cartItem);
    List<CartItem> findByCustomer(Customer customer);
    void delete(CartItem cartItem);
}