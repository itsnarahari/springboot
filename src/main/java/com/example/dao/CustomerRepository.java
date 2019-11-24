package com.example.dao;

import com.example.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    @Query(value = "SELECT * FROM customer WHERE email = ?1",nativeQuery = true)
    public List<Customer> findByEmailAddress(String emailAddress);
}
