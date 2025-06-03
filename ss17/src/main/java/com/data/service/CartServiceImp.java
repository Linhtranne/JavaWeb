package com.data.service;

import com.data.entity.CartItem;
import com.data.entity.Customer;
import com.data.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartServiceImp implements CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> getCartItemsByCustomer(Customer customer) {
        return cartItemRepository.findByCustomer(customer);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
}