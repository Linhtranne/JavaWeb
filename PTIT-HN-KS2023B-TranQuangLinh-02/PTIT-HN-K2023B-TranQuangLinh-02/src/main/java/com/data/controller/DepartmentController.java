package com.data.controller;

import com.data.model.Department;
import com.data.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String listDepartments(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "DepartmentView";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("department", new Department());
        return "AddDepartment";
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute Department department) {
        departmentService.addDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "EditDepartment";
    }

    @PostMapping("/edit")
    public String editDepartment(@ModelAttribute Department department) {
        departmentService.updateDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable int id, Model model) {
        boolean isDeleted = departmentService.deleteDepartment(id);
        if (!isDeleted) {
            model.addAttribute("error", "Không thể xóa phòng ban đang có nhân viên.");
        }
        return "redirect:/departments";
    }

    @GetMapping("/search")
    public String searchDepartment(@RequestParam String searchName, Model model) {
        List<Department> departments = departmentService.searchDepartmentsByName(searchName);
        model.addAttribute("departments", departments);
        return "DepartmentView";
    }
}