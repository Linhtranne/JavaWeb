package com.data.service;

import com.data.model.Employees;

import java.util.List;

public interface EmployeesService {
    void addEmployee(String name, String position);
    void removeEmployee(int employeeId);
    void updateEmployee(int employeeId, String name, String position);
    String getEmployeeDetails(int employeeId);
    List<Employees> listAllEmployees();
}
