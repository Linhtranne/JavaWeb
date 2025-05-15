package com.data.ss8.controller;

import com.data.ss8.model.Product;
import com.data.ss8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("productList", products);
        return "listProduct";
    }
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/add")
    public String submitForm(@ModelAttribute("product") Product product, Model model) {
        product.setId(indexId++);
        model.addAttribute("newProduct", product);
        return "viewProduct";
    }

}