package com.data.ss8.controller;

import com.data.ss8.model.Customer;
import com.data.ss8.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("Controller")
    public String findAll(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "Customer";
    }
}
