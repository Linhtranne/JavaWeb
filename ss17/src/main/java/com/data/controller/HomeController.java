package com.data.controller;

import com.data.entity.Product;
import com.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String home(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size,
                       Model model) {
        List<Product> products = productService.findAllWithPagination(page, size);
        long totalProducts = productService.getTotalProducts();
        int totalPages = (int) Math.ceil((double) totalProducts / size);
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("size", size);
        return "home";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "error";
        }
        model.addAttribute("product", product);
        return "product-details";
    }
}