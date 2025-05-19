package com.data.ss10.controller;

import com.data.ss10.model.Account;
import com.data.ss10.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/registerForm")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        return "Bai3/registerForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("account") Account account, Model model) {
        accountService.save(account);
        model.addAttribute("message", "Đăng ký thành công!");
        return "/registerSuccess";
    }
}

