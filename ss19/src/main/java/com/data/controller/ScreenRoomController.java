package com.data.controller;

import com.data.entity.ScreenRoom;
import com.data.service.ScreenRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/screen-rooms")
public class ScreenRoomController {

    private final ScreenRoomService screenRoomService;

    public ScreenRoomController(ScreenRoomService screenRoomService) {
        this.screenRoomService = screenRoomService;
    }

    @GetMapping
    public String listScreenRooms(Model model) {
        List<ScreenRoom> screenRooms = screenRoomService.getAllActiveScreenRooms();
        model.addAttribute("screenRooms", screenRooms);
        return "screen-room-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("screenRoom", new ScreenRoom());
        return "screen-room-form";
    }

    @PostMapping("/add")
    public String addScreenRoom(@Valid @ModelAttribute("screenRoom") ScreenRoom screenRoom, BindingResult result) {
        if (result.hasErrors()) {
            return "screen-room-form";
        }
        screenRoomService.saveScreenRoom(screenRoom);
        return "redirect:/screen-rooms";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ScreenRoom screenRoom = screenRoomService.getScreenRoomById(id);
        model.addAttribute("screenRoom", screenRoom);
        return "screen-room-form";
    }

    @PostMapping("/edit/{id}")
    public String editScreenRoom(@Valid @ModelAttribute("screenRoom") ScreenRoom screenRoom, BindingResult result) {
        if (result.hasErrors()) {
            return "screen-room-form";
        }
        screenRoomService.saveScreenRoom(screenRoom);
        return "redirect:/screen-rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteScreenRoom(@PathVariable Long id) {
        screenRoomService.deleteScreenRoom(id);
        return "redirect:/screen-rooms";
    }
}