package com.ss3.ss3;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private List<ProductEx10> cart = new ArrayList<>();

    public void addProduct(ProductEx10 ProductEx10) {
        for (ProductEx10 p : cart) {
            if (p.getId() == ProductEx10.getId()) {
                return;
            }
        }
        cart.add(ProductEx10);
    }

    public List<ProductEx10> getCart() {
        return cart;
    }

    public void removeProduct(int id) {
        cart.removeIf(product -> product.getId() == id);
    }

    public double getTotalPrice() {
        return cart.stream().mapToDouble(ProductEx10::getPrice).sum();
    }
}