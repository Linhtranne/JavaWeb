package com.data.service;

import com.data.model.Ex6789.Cart;
import com.data.model.Ex6789.Orders;
import com.data.model.Ex6789.Product;
import com.data.model.Ex6789.Review;

import java.util.List;

public interface ReviewService {
    boolean addReview(Review review);
    List<Product> getAllProducts();
    List<Review> getReviewsByProductId(int productId);
    Product getProductById(int id);
    boolean addToCart(Cart cart);
    List<Cart> getCartByUserId(int userId);
    boolean addOrder(Orders orders);
}
