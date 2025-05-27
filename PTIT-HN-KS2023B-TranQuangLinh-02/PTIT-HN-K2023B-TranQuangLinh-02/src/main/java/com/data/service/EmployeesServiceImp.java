package com.data.service;

import com.data.model.Employees;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImp implements EmployeesService {

    @Override
    public void addEmployee(String name, String position) {

    }

    @Override
    public void removeEmployee(int employeeId) {

    }

    @Override
    public void updateEmployee(int employeeId, String name, String position) {

    }

    @Override
    public String getEmployeeDetails(int employeeId) {
        return "";
    }

    @Override
    public List<Employees> listAllEmployees() {
        return null;
    }
}
