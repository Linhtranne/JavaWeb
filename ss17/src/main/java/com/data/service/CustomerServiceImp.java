package com.data.service;

import com.data.entity.Customer;
import com.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        return customerRepository.findByUsernameAndPassword(username, password);
    }
    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
}
