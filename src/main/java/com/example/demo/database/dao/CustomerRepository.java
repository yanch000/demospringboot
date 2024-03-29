package com.example.demo.database.dao;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.database.models.Customer;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}