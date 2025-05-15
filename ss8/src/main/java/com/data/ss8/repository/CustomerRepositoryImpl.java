package com.data.ss8.repository;

import com.data.ss8.connection.ConnectionDB;
import com.data.ss8.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Customer> customers = new ArrayList<>();
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all()}");
            ResultSet rs = callSt.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setGender(rs.getString("gender"));
                customer.setCustomerType(rs.getString("customerType"));
                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return null;
    }
}
