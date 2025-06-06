package com.data.ss8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("message", "Chào mừng đến với ứng dụng của chúng tôi!");
        return mav;

    }
    }