package com.data.service;

import com.data.entity.Customer;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Customer findByUsernameAndPassword(String username, String password);
    Customer findById(int id);
}
