package com.data.controller;

import com.data.entity.CartItem;
import com.data.entity.Customer;
import com.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        Customer customer = customerService.findById(customerId);
        List<CartItem> cartItems = customer.getCartItems();
        double total = cartItems.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);
        return "cart";
    }

    @PostMapping("/cart/update")
    public String updateCartItem(@RequestParam int itemId, @RequestParam int quantity, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        Customer customer = customerService.findById(customerId);
        CartItem item = customer.getCartItems().stream().filter(i -> i.getId() == itemId).findFirst().orElse(null);
        if (item != null) {
            item.setQuantity(quantity);
            customerService.saveCustomer(customer);
        }
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeCartItem(@RequestParam int itemId, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        Customer customer = customerService.findById(customerId);
        CartItem item = customer.getCartItems().stream().filter(i -> i.getId() == itemId).findFirst().orElse(null);
        if (item != null) {
            customer.getCartItems().remove(item);
            customerService.saveCustomer(customer);
        }
        return "redirect:/cart";
    }
}