package com.data.repository;

import com.data.model.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> findAll();
    Department findById(int id);
    void save(Department department);
    void update(Department department);
    boolean delete(int id);
    List<Department> searchByName(String name);
}