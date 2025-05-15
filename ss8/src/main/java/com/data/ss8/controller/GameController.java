package com.data.ss8.controller;


import com.data.ss8.model.Seeds;
import com.data.ss8.model.Users;
import com.data.ss8.model.WarehouseSeeds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class GameController {
    private List<Seeds> seedList = new ArrayList<>();
    private Map<String, List<WarehouseSeeds>> warehouseMap = new HashMap<>();
    private Map<String, Map<Integer, Seeds>> farmMap = new HashMap<>();
    private List<Users> Userss = new ArrayList<>();
    private int UsersIdCounter = 1;

    public GameController() {
        seedList.add(new Seeds(1, "Cà chua", 1000, "https://favri.org.vn/images/anh_tinkhoahoc/Ca_chua.jpg"));
        seedList.add(new Seeds(2, "Bắp cải", 1500, "https://image.tienphong.vn/w890/Uploaded/2025/rkznae/2019_12_16/cai_bap_1416685665757_42_4_422_521_crop_1416685674608_IAHA.jpg"));
        seedList.add(new Seeds(3, "Ớt", 2000, "https://hongngochospital.vn/wp-content/uploads/2013/11/doi-tuong-khong-nen-an-ot-1.jpg"));
    }

    @GetMapping("/game")
    public String home(HttpSession session) {
        return (session.getAttribute("Users") == null) ? "redirect:/login" : "farm/home";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "farm/register";
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String Usersname, @RequestParam String password, @RequestParam String email, HttpSession session) {
        Users Users = new Users();
        Users.setId(UsersIdCounter++);
        Users.setUsersname(Usersname);
        Users.setPassword(password);
        Users.setEmail(email);
        Userss.add(Users);
        session.setAttribute("Users", Users);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "farm/login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String Usersname, @RequestParam String password, HttpSession session) {
        for (Users u : Userss) {
            if (u.getUsersname().equals(Usersname) && u.getPassword().equals(password)) {
                session.setAttribute("Users", u);
                return "redirect:/game";
            }
        }
        return "farm/login";
    }

    @GetMapping("/shop")
    public ModelAndView showShop(HttpSession session) {
        Users Users = (Users) session.getAttribute("Users");
        if (Users == null) return new ModelAndView("redirect:/login");
        ModelAndView mav = new ModelAndView("farm/shop");
        mav.addObject("seeds", seedList);
        mav.addObject("Users", Users);
        return mav;
    }

    @PostMapping("/buy")
    public String buySeed(@RequestParam int seedId, HttpSession session) {
        Users Users = (Users) session.getAttribute("Users");
        if (Users == null) return "redirect:/login";

        Seeds selected = seedList.stream().filter(s -> s.getId() == seedId).findFirst().orElse(null);
        if (selected != null && Users.getBalance() >= selected.getPrice()) {
            Users.setBalance(Users.getBalance() - selected.getPrice());
            List<WarehouseSeeds> UsersWarehouse = warehouseMap.computeIfAbsent(Users.getUsersname(), k -> new ArrayList<>());
            WarehouseSeeds item = UsersWarehouse.stream().filter(ws -> ws.getSeeds().getId() == seedId).findFirst().orElse(null);
            if (item == null) {
                WarehouseSeeds newItem = new WarehouseSeeds();
                newItem.setId(seedId);
                newItem.setSeeds(selected);
                newItem.setQuantity(1);
                UsersWarehouse.add(newItem);
            } else {
                item.setQuantity(item.getQuantity() + 1);
            }
        }

        return "redirect:/shop";
    }

    @GetMapping("/warehouse")
    public ModelAndView showWarehouse(HttpSession session) {
        Users Users = (Users) session.getAttribute("Users");
        if (Users == null) return new ModelAndView("redirect:/login");
        List<WarehouseSeeds> warehouse = warehouseMap.getOrDefault(Users.getUsersname(), new ArrayList<>());
        ModelAndView mav = new ModelAndView("farm/warehouse");
        mav.addObject("warehouseSeeds", warehouse);
        return mav;
    }

    @GetMapping("/farm")
    public ModelAndView showFarm(HttpSession session) {
        Users Users = (Users) session.getAttribute("Users");
        if (Users == null) return new ModelAndView("redirect:/login");

        Map<Integer, Seeds> plots = farmMap.computeIfAbsent(Users.getUsersname(), k -> {
            Map<Integer, Seeds> newMap = new HashMap<>();
            for (int i = 1; i <= 20; i++) newMap.put(i, null);
            return newMap;
        });

        List<WarehouseSeeds> warehouse = warehouseMap.getOrDefault(Users.getUsersname(), new ArrayList<>());
        ModelAndView mav = new ModelAndView("farm/farm");
        mav.addObject("plots", plots);
        mav.addObject("warehouseSeeds", warehouse);
        return mav;
    }

    @PostMapping("/plant")
    public String plantSeed(@RequestParam int plotNumber, @RequestParam int seedId, HttpSession session) {
        Users Users = (Users) session.getAttribute("Users");
        if (Users == null) return "redirect:/login";

        List<WarehouseSeeds> warehouse = warehouseMap.getOrDefault(Users.getUsersname(), new ArrayList<>());
        WarehouseSeeds seedInStock = warehouse.stream()
                .filter(ws -> ws.getSeeds().getId() == seedId && ws.getQuantity() > 0)
                .findFirst().orElse(null);

        if (seedInStock == null) return "redirect:/farm";

        Map<Integer, Seeds> plots = farmMap.get(Users.getUsersname());
        if (plots.get(plotNumber) == null) {
            plots.put(plotNumber, seedInStock.getSeeds());
            seedInStock.setQuantity(seedInStock.getQuantity() - 1);
        }

        return "redirect:/farm";
    }
}