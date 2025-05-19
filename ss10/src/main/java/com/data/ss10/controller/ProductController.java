package com.data.ss10.controller;

import com.data.ss10.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @GetMapping("/productForm")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "/productForm";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product, Model model) {

        model.addAttribute("product", product);
        return "/resultProduct";
    }
}