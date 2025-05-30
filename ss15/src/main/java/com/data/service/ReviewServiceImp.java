package com.data.service;

import com.data.model.Ex6789.Cart;
import com.data.model.Ex6789.Orders;
import com.data.model.Ex6789.Product;
import com.data.model.Ex6789.Review;
import com.data.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public boolean addReview(Review review) {
        return reviewRepository.addReview(review);
    }

    @Override
    public List<Product> getAllProducts() {
        return reviewRepository.getAllProducts();
    }

    @Override
    public List<Review> getReviewsByProductId(int productId) {
        return reviewRepository.getReviewsByProductId(productId);
    }

    @Override
    public Product getProductById(int id) {
        return reviewRepository.getProductById(id);
    }

    @Override
    public boolean addToCart(Cart cart) {
        return reviewRepository.addToCart(cart);
    }

    @Override
    public List<Cart> getCartByUserId(int userId) {
        return reviewRepository.getCartByUserId(userId);
    }

    @Override
    public boolean addOrder(Orders orders) {
        return reviewRepository.addOrder(orders);
    }

}
