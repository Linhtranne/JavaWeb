package com.data.service;

import com.data.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
    void addDepartment(Department department);
    void updateDepartment(Department department);
    boolean deleteDepartment(int id);
    List<Department> searchDepartmentsByName(String name);
}