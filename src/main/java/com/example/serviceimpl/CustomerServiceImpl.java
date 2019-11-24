package com.example.serviceimpl;

import com.example.dao.CustomerRepository;
import com.example.model.Customer;
import com.example.services.CustomerServices;
import com.example.util.KeyValue;
import com.example.util.KeyValue2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*

@CustomerServiceImpl Service class for Customer

@Written By Narahari

 */

@Service
public class CustomerServiceImpl implements CustomerServices {

    @Autowired
    CustomerRepository customerRepository;

    // It will saves the customer into db if email is not present.
    @Override
    public Integer save(Customer customer) {

        customer.getName();
        customer.getEmail();
        customer.getMobile();
        customerRepository.save(customer);
        return customer.getId();
    }

    // Get all Customers.
    @Override
    public List<Customer> getAll() {

        return (List<Customer>) customerRepository.findAll();
    }

    // Get customer by Id.
    @Override
    public Object findById(Long id) {

        Object obj = customerRepository.findById(Math.toIntExact(id)).isPresent()?customerRepository.findById(Math.toIntExact(id)): null;

        if (obj != null) {
            return obj;
        } else {
            KeyValue2 keyValue2 = new KeyValue2();
            keyValue2.setMessage("Given id not found");
            return keyValue2;
        }
    }

    // Check is email exist or not.
    @Override
    public boolean isExist(String email) {
        List<Customer> customer = customerRepository.findByEmailAddress(email);
        if (!customer.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // Update the Customer based on Id.
    @Override
    public boolean updateCustomer(Customer customer) {

        Customer customer2 = customerRepository.findById(customer.getId()).get();
        if (customer != null) {
            customer.setId(customer2.getId());
            customer.getName();
            customer.getEmail();
            customer.getMobile();
            customerRepository.save(customer);
            return true;
        } else {
            return false;
        }
    }

    // Delete the Customer by Id.
    @Override
    public void deleteCustomerById(Integer id) {
            customerRepository.deleteById(id);
    }
}
