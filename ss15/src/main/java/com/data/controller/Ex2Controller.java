package com.data.controller;

import com.data.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Ex2Controller {

    @GetMapping("/ex2")
    public String getStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("1", "A", 20, "10A", "123", "123", "123456789"));
        students.add(new Student("2", "b", 22, "10B", "234", "234", "987654321"));
        students.add(new Student("3", "C", 19, "10C", "345", "567", "456789123"));

        model.addAttribute("students", students);
        return "Ex2";
    }
}