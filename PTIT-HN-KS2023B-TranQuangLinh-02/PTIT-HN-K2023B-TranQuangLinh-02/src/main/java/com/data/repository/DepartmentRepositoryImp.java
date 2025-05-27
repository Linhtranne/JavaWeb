package com.data.repository;

import com.data.model.Department;
import com.data.model.DepartmentStatus;
import com.data.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepositoryImp implements DepartmentRepository {

    @Override
    public List<Department> findAll() {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        List<Department> departments = new ArrayList<>();
        try {
            callSt = conn.prepareCall("{call GetAllDepartments()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Department department = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getString("description"),
                        DepartmentStatus.valueOf(rs.getString("status").toUpperCase())
                );
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departments;
    }

    @Override
    public Department findById(int id) {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        Department department = null;
        try {
            callSt = conn.prepareCall("{call GetDepartmentById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                department = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getString("description"),
                        DepartmentStatus.valueOf(rs.getString("status").toUpperCase())
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return department;
    }

    @Override
    public void save(Department department) {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call AddDepartment(?, ?, ?)}");
            callSt.setString(1, department.getDepartmentName());
            callSt.setString(2, department.getDescription());
            callSt.setString(3, department.getStatus().name());
            callSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void update(Department department) {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        try {
            callSt = conn.prepareCall("{call UpdateDepartment(?, ?, ?, ?)}");
            callSt.setInt(1, department.getDepartmentId());
            callSt.setString(2, department.getDepartmentName());
            callSt.setString(3, department.getDescription());
            callSt.setString(4, department.getStatus().name());
            callSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public boolean delete(int id) {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        boolean isDeleted = false;
        try {
            callSt = conn.prepareCall("{call DeleteDepartment(?)}");
            callSt.setInt(1, id);
            isDeleted = callSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return isDeleted;
    }

    @Override
    public List<Department> searchByName(String name) {
        Connection conn = ConnectionDB.openConnection();
        CallableStatement callSt = null;
        List<Department> departments = new ArrayList<>();
        try {
            callSt = conn.prepareCall("{call SearchDepartmentsByName(?)}");
            callSt.setString(1, "%" + name + "%");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Department department = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getString("description"),
                        DepartmentStatus.valueOf(rs.getString("status").toUpperCase())
                );
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departments;
    }
}