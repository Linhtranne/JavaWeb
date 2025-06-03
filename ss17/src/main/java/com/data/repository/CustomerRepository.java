package com.data.repository;

import com.data.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    List<Customer> getAll();
    Customer findByUsernameAndPassword(String username, String password);
    Customer findById(int id);
}
