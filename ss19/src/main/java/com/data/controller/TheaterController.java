package com.data.controller;

import com.data.entity.Theater;
import com.data.service.TheaterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public String listTheaters(Model model) {
        List<Theater> theaters = theaterService.getAllTheaters();
        model.addAttribute("theaters", theaters);
        return "theater-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("theater", new Theater());
        return "theater-form";
    }

    @PostMapping("/add")
    public String addTheater(@Valid @ModelAttribute("theater") Theater theater, BindingResult result) {
        if (result.hasErrors()) {
            return "theater-form";
        }
        theaterService.saveTheater(theater);
        return "redirect:/theaters";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Theater theater = theaterService.getTheaterById(id);
        model.addAttribute("theater", theater);
        return "theater-form";
    }

    @PostMapping("/edit/{id}")
    public String editTheater(@Valid @ModelAttribute("theater") Theater theater, BindingResult result) {
        if (result.hasErrors()) {
            return "theater-form";
        }
        theaterService.saveTheater(theater);
        return "redirect:/theaters";
    }

    @GetMapping("/delete/{id}")
    public String deleteTheater(@PathVariable Long id) {
        Theater theater = theaterService.getTheaterById(id);
        if (theater != null && Boolean.parseBoolean(theater.getStatus())) {
            theater.setStatus(false);
            theaterService.saveTheater(theater);
        } else {
            theaterService.deleteTheater(id);
        }
        return "redirect:/theaters";
    }
}