package com.data.controller;

import com.data.entity.User;
import com.data.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "5") int size,
                            Model model) {
        List<User> users = userService.getUsers(page, size);
        long totalUsers = userService.getTotalUsers();
        int totalPages = (int) Math.ceil((double) totalUsers / size);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "user-list";
    }

    @PostMapping("/change-status")
    public String changeUserStatus(@RequestParam Long userId, @RequestParam boolean isActive) {
        userService.changeUserStatus(userId, isActive);
        return "redirect:/users";
    }
}