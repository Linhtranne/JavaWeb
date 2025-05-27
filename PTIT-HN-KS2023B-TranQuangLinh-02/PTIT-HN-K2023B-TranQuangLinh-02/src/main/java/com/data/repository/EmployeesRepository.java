package com.data.repository;

import com.data.model.Employees;

import java.util.List;

public interface EmployeesRepository {
    List<Employees> findAll();
    Employees findByName(String name);
    Employees editEmployee(Employees employee);
    Employees deleteEmployee(int employeeId);
    Employees addEmployee(Employees employee);

}
