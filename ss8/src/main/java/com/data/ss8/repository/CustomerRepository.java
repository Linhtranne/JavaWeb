package com.data.ss8.repository;

import com.data.ss8.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}
