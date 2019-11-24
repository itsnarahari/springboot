package com.example.controller;


import com.example.model.Customer;
import com.example.serviceimpl.CustomerServiceImpl;
import com.example.util.KeyValue;
import com.example.util.KeyValue2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    /*
    @Written By Narahari
     */

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {

        boolean status = customerServiceImpl.isExist(customer.getEmail());

        if(status==true)
        {
            KeyValue2 keyValue2 = new KeyValue2();
            keyValue2.setMessage("Given email id is already exist..!");
            return new ResponseEntity(keyValue2, HttpStatus.OK);
        }
        else
        {
            Integer gen_id = customerServiceImpl.save(customer);

            KeyValue keyValue = new KeyValue();

            keyValue.setKey(gen_id);
            return new ResponseEntity(keyValue, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<List<Customer>>(customerServiceImpl.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomerById(@PathVariable int id) {

        Object obj = customerServiceImpl.findById((long) id);
        return new ResponseEntity<Object>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateCustomer(@RequestBody Customer customer) {

        return new ResponseEntity(customerServiceImpl.updateCustomer(customer) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCustomerById(@PathVariable Integer id) {

        customerServiceImpl.deleteCustomerById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
