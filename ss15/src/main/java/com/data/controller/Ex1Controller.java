package com.data.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ex1Controller {

    @GetMapping("/ex1")
    public String home(Model model) {
        model.addAttribute("message", "Linhtranne");
        return "Ex1";
    }
}