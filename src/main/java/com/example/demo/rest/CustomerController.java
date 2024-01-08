package com.example.demo.rest;
import com.example.demo.database.models.CustomerModel;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.database.models.Customer;
import com.example.demo.database.dao.CustomerRepository;
// This means that this class is a RestController
@RestController
@RequestMapping(path = "/demo")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/update", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    void updateCustomer(@RequestBody CustomerModel customerModel) {
        customerService.updateCustomer(customerModel);
    }

    @PostMapping(path = "/add")
    public @ResponseBody Customer addNewCustomer(@RequestParam String name, @RequestParam String email) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customerRepository.save(customer);
        return customer;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}