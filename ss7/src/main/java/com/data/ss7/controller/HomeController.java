package com.data.ss7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/homes")
public class HomeController {

    @GetMapping
    public ModelAndView home(@RequestParam String name) {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", "Hello, " + name + "!");
        return mav;
    }
}
