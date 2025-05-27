package com.data.repository;

import com.data.model.Employees;
import com.data.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesRepositoryImp implements EmployeesRepository {
    @Override
    public List<Employees> findAll() {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call views_all_employees()}");
            callSt.execute();
            List<Employees> employeesList = new ArrayList<>();

            ResultSet rs = callSt.getResultSet();
            while (rs.next()) {
            Employees employee = new Employees();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setFullName(rs.getString("full_name"));
            employee.setEmail(rs.getString("email"));
            employee.setPhoneNumber(rs.getString("phone_number"));
            employee.setAvatarUrl(rs.getString("avatar_url"));
            employee.setCreatedAt(rs.getDate("created_at"));
            employeesList.add(employee);
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return null;
    }

    @Override
    public Employees findByName(String name) {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        try{
            callSt = conn.prepareCall("{call find_employee_by_name(?)}");
            callSt.setString(1, name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return null;
    }

    @Override
    public Employees editEmployee(Employees employee) {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call edit_employee(?, ?, ?, ?)}");
            callSt.setInt(1, employee.getEmployeeId());
            callSt.setString(2, employee.getFullName());
            callSt.setString(3, employee.getEmail());
            callSt.setString(4, employee.getPhoneNumber());
            callSt.setString(5, employee.getAvatarUrl());
            callSt.setDate(6, (Date) employee.getCreatedAt());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return null;
    }

    @Override
    public Employees deleteEmployee(int employeeId) {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;

        return null;
    }

    @Override
    public Employees addEmployee(Employees employee) {
        return null;
    }
}
