package com.example.demo.services;

import com.example.demo.database.dao.CustomerDao;
import com.example.demo.database.models.CustomerModel;
import com.example.demo.database.models.Customer;
import com.example.demo.database.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
    public class CustomerService {
        @Autowired
        private CustomerDao customerDao;
        @Autowired
        private CustomerRepository customerRepository;

        public CustomerService(){

        }

        public void updateCustomer(CustomerModel customerModel) {
            Optional<Customer> optionalCustomer = customerRepository.findById(customerModel.getId());
            Customer customer = optionalCustomer.get();
            if (!"".equals(customerModel.getId()) | !"".equals(customerModel.getName()) |  !"".equals(customerModel.getEmail())) {
                customer.setId(customerModel.getId());
                customer.setName(customerModel.getName());
                customer.setEmail(customerModel.getEmail());
                customerRepository.save(customer);
            }
        }

        private CustomerModel getModel(Customer customer) {
            CustomerModel model = new CustomerModel();
            model.setId(customer.getId());
            model.setName(customer.getName());
            model.setEmail(customer.getEmail());
            return model;
        }
    }