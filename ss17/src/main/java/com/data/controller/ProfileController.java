package com.data.controller;

import com.data.entity.Customer;
import com.data.entity.Order;
import com.data.service.CustomerService;
import com.data.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model, @RequestParam(defaultValue = "0") int page) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        Customer customer = customerService.findById(customerId);
        int size = 5;
        List<Order> orders = orderService.getOrdersByCustomerId(customerId, page, size);
        int totalOrders = orderService.getTotalOrdersByCustomerId(customerId);
        int totalPages = (int) Math.ceil((double) totalOrders / size);

        model.addAttribute("customer", customer);
        model.addAttribute("orders", orders);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute Customer customer, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        customer.setId(customerId);
        customerService.saveCustomer(customer);
        return "redirect:/profile";
    }

    @PostMapping("/order/cancel")
    public String cancelOrder(@RequestParam int orderId, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        Order order = orderService.getOrderById(orderId);
        if (order != null && order.getCustomerId() == customerId) {
            orderService.deleteOrder(order);
        }
        return "redirect:/profile";
    }
}