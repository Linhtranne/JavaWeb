package com.data.controller;

import com.data.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Ex3Controller {

    @GetMapping("/ex3")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "ex3";
    }

    @PostMapping("/register")
    public String submitForm( @ModelAttribute("user") User user,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "ex3";
        }
        return "ex3result";
    }
}
