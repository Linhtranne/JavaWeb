package com.data.service;

import com.data.entity.CartItem;
import com.data.entity.Customer;
import java.util.List;

public interface CartService {
    List<CartItem> getCartItemsByCustomer(Customer customer);
    void updateCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
}
