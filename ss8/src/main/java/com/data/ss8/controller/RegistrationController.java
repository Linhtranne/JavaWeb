package com.data.ss8.controller;


import com.data.ss8.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    private static int idCounter = 1;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String submitForm(@ModelAttribute("user") User user, Model model) {

        List<String> errors = new ArrayList<>();
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            errors.add("Username không được để trống.");
        }
        if (user.getPhone() == null || !user.getPhone().matches("\\d{9,11}")) {
            errors.add("Số điện thoại không hợp lệ (chỉ chứa số và 9-11 ký tự).");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            errors.add("Email không được để trống.");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "register";
        }

        user.setId(idCounter++);

        model.addAttribute("user", user);
        return "resultRegister";
    }
}
