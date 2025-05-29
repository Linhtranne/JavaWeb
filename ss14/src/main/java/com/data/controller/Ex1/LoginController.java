package com.data.controller.Ex1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "/WEB-INF/login.jsp";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request,
            Model model) {

        if ("linhtranne".equals(username) && "123456".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Tên người dùng hoặc mật khẩu không đúng");
            return "/WEB-INF/views/login.jsp";
        }
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        return "welcome";
    }

}
