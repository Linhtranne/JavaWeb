package com.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ex4Controller {
    @GetMapping("/home")
    public String home() {
        return "Ex4/home";
    }

    @GetMapping("/about")
    public String about() {
        return "Ex4/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "Ex4/contact";
    }
}
