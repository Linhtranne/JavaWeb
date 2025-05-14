package com.data.ss7.controller;

import com.data.ss7.model.Ex8Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    @RequestMapping("/product/{category}")
    public String getProductsByCategory(
            @PathVariable String category,
            @MatrixVariable(pathVar = "category", value = "color", required = false) String color,
            @MatrixVariable(pathVar = "category", value = "size", required = false) String size,
            Model model) {

        List<Ex8Product> ex8Products = new ArrayList<>();

ex8Products.add(new Ex8Product("Áo sơ mi", "đỏ", "M"));
ex8Products.add(new Ex8Product("Quần jean", "xanh", "L"));
ex8Products.add(new Ex8Product("Áo khoác", "đen", "XL"));
ex8Products.add(new Ex8Product("Váy", "trắng", "S"));
ex8Products.add(new Ex8Product("Mũ", "xanh", "M"));


        List<Ex8Product> filtered = ex8Products.stream()
                .filter(p -> (color == null || p.getColor().equalsIgnoreCase(color)))
                .filter(p -> (size == null || p.getSize().equalsIgnoreCase(size)))
                .collect(Collectors.toList());

        model.addAttribute("products", filtered);
        model.addAttribute("category", category);
        model.addAttribute("color", color);
        model.addAttribute("size", size);

        return "product";
    }
}
