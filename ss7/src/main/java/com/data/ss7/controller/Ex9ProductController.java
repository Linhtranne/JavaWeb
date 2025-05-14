package com.data.ss7.controller;

import com.data.ss7.model.Category;
import com.data.ss7.model.Ex9Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller("Ex9ProductController")
@RequestMapping("ex9products")
public class Ex9ProductController {

    private final List<Category> categoryList = Arrays.asList(
            new Category(1, "Electronics"),
            new Category(2, "Clothing"),
            new Category(3, "Books")
    );

    private final List<Ex9Product> ex9ProductList = new ArrayList<>();
    private int productIdSequence = 1;

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryList;
    }

    @GetMapping
    public String listProducts(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Ex9Product> filtered = ex9ProductList;

        if (keyword != null && !keyword.trim().isEmpty()) {
            filtered = ex9ProductList.stream()
                    .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                    .toList();
        }

        model.addAttribute("products", filtered);
        return "ex9ProductList";
    }

    @GetMapping("/{id}")
    public String showProductDetails(@PathVariable int id, Model model) {
        Ex9Product ex9Product = findById(id);
        if (ex9Product == null) return "redirect:/b9/products";
        model.addAttribute("product", ex9Product);
        return "productDetails";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Ex9Product());
        return "addProduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Ex9Product ex9Product, RedirectAttributes redirectAttributes) {
        ex9Product.setId(productIdSequence++);
        ex9ProductList.add(ex9Product);
        redirectAttributes.addFlashAttribute("message", "Sản phẩm đã được thêm thành công!");
        return "redirect:/Bai9/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Ex9Product ex9Product = findById(id);
        if (ex9Product == null) return "redirect:/products";
        model.addAttribute("product", ex9Product);
        return "editProduct";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Ex9Product updatedEx9Product, RedirectAttributes redirectAttributes) {
        Ex9Product ex9Product = findById(updatedEx9Product.getId());
        if (ex9Product != null) {
            ex9Product.setName(updatedEx9Product.getName());
            ex9Product.setPrice(updatedEx9Product.getPrice());
            ex9Product.setCategoryId(updatedEx9Product.getCategoryId());
            redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        }
        return "redirect:/Bai9/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ex9ProductList.removeIf(p -> p.getId() == id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa sản phẩm thành công!");
        return "redirect:/Bai9/products";
    }

    private Ex9Product findById(int id) {
        return ex9ProductList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
