package com.data.ss8.controller;


import com.data.ss8.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping
    public String showEmployeeList(Model model) {
        model.addAttribute("employees", employeeList);
        return "listEmployee";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeList.add(employee);
        model.addAttribute("successMessage", "Thêm nhân viên thành công!");
        model.addAttribute("employees", employeeList);
        return "listEmployee";
    }
}
