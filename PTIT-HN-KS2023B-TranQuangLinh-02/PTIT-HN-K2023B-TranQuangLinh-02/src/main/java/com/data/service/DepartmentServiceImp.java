package com.data.service;

import com.data.model.Department;
import com.data.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.update(department);
    }

    @Override
    public boolean deleteDepartment(int id) {
        return departmentRepository.delete(id);
    }

    @Override
    public List<Department> searchDepartmentsByName(String name) {
        return departmentRepository.searchByName(name);
    }
}