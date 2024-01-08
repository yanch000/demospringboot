package com.example.demo.database.dao;

import com.example.demo.database.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerDao {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDao() {

    }

    public Customer getCustomerById(long id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new Exception("Customer is not present!");
    }
}