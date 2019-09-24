package com.example.controller;

import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.List;

import com.example.util.KeyValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.Users;
import com.example.serviceimpl.UserServicesImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    UserServicesImpl userServicesImpl;

    KeyValue keyValue = new KeyValue();

    @RequestMapping(value = "/index",method = RequestMethod.GET,produces = "application/json")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody Users users) {

        boolean flag = userServicesImpl.isEmailExist(users.getEmail());

        if (flag == false) {
            String val = userServicesImpl.saveUser(users);
            keyValue.setKey(val);

        } else {
            keyValue.setKey("Already Exist");
        }
        return new ResponseEntity(keyValue, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> getAllUsers() {

        return new ResponseEntity<List<Users>>(userServicesImpl.getAllUsers(), HttpStatus.OK);

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Users> getUsersById(@PathVariable int id) {

        return new ResponseEntity(userServicesImpl.getUsersById(id), HttpStatus.OK);

    }

    @PutMapping(value = "/users")
    public Integer updateUsersById(@RequestBody Users users) {

        return userServicesImpl.updateUsersById(users);
    }

    @DeleteMapping(value = "/users/{id}")
    public Integer deleteUsersById(@PathVariable int id) {

        return userServicesImpl.deleteUsersById(id);
    }

}
