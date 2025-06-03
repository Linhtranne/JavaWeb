package com.data.controller;

import com.data.entity.Customer;
import com.data.entity.Order;
import com.data.service.CustomerService;
import com.data.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/order/checkout")
    public String showCheckoutForm(HttpSession session, Model model) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer", customer);
        return "checkout";
    }

    @PostMapping("/order/checkout")
    public String processCheckout(@RequestParam String recipientName,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String address,
                                  HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setRecipientName(recipientName);
        order.setPhoneNumber(phoneNumber);
        order.setAddress(address);
        orderService.saveOrder(order);
        return "redirect:/order/confirmation";
    }
}