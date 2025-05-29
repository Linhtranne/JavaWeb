package com.data.controller.Ex8;

import com.data.model.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class Ex8Controller {

    @GetMapping("/orderBai8")
    public String showOrderForm() {
        return "orderForm";
    }

    @PostMapping("/orderBai8")
    public String placeOrder(
            @RequestParam String username,
            @RequestParam String product,
            @RequestParam int quantity,
            HttpSession session,
            Model model
    ) {
        List<OrderItem> orders = (List<OrderItem>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }

        orders.add(new OrderItem(username, product, quantity));
        session.setAttribute("orders", orders);

        model.addAttribute("message", "Đặt hàng thành công!");
        return "orderForm";
    }

    @GetMapping("/Ex8")
    public String viewOrders(HttpSession session, Model model) {
        List<OrderItem> orders = (List<OrderItem>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }
        model.addAttribute("orders", orders);
        return "orderList";
    }
}

