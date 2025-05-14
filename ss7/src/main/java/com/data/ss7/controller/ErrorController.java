package com.data.ss7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("error");
        return mav;
    }
}
