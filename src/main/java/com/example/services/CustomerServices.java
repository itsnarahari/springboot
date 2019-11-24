package com.example.services;

import com.example.model.Customer;

import java.util.List;

public interface CustomerServices {

    public Integer save(Customer customer);

    public List<Customer> getAll();

    public Object findById(Long id);

    public boolean isExist(String email);

    public boolean updateCustomer(Customer customer);

    public void deleteCustomerById(Integer id);

}
