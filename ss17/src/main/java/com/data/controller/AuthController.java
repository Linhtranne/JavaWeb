package com.data.controller;

import com.data.entity.Customer;
import com.data.entity.CustomerRole;
import com.data.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private CustomerServiceImp customerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        customer.setStatus(true);
        customerService.saveCustomer(customer);
        model.addAttribute("message", "Đăng ký thành công!");
        return "success";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Customer customer = customerService.findByUsernameAndPassword(username, password);
        if (customer != null && customer.isStatus()) {
            if (customer.getRole() == CustomerRole.ADMIN) {
                return "redirect:/admin";
            } else if (customer.getRole() == CustomerRole.USER) {
                return "redirect:/home";
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}