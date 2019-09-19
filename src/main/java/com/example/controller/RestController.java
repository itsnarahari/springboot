package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.util.KeyValue;
import org.apache.catalina.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Users;
import com.example.serviceimpl.UserServicesImpl;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    UserServicesImpl userServicesImpl;

    KeyValue keyValue = new KeyValue();

    @RequestMapping(value  = "/")
    public String index() {
        return "index";
    }

//    @RequestMapping(value = "/users/add",method = RequestMethod.POST)
//    public String createUser(@RequestBody Users users)  {
//
//        System.out.println(users.getEmail()+users.getMobile()+users.getMobile());
//        boolean flag = userServicesImpl.isEmailExist(users.getEmail());
//
//        if(flag==false)
//        {
//            String val = userServicesImpl.saveUser(users);
//
//            return val;
//        }
//        else
//        {
//            return "Already Exist";
//        }
//    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody Users users)  {

        JSONObject jsonObject = new JSONObject();
        boolean flag = userServicesImpl.isEmailExist(users.getEmail());

        List list = new ArrayList();

        if(flag==false)
        {
            String val = userServicesImpl.saveUser(users);
            keyValue.setKey(val);

            return new ResponseEntity(keyValue, HttpStatus.OK);
        }
        else
        {
            keyValue.setKey("Already Exist");
            return new ResponseEntity(keyValue, HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResponseEntity<List<Users>> getAllUsers() {

        return new ResponseEntity<List<Users>>(userServicesImpl.getAllUsers(), HttpStatus.OK);

    }

    @RequestMapping(value  = "/users/{id}",method = RequestMethod.GET)
    public ResponseEntity<Users> getUsersById(@PathVariable int id) {

        return new ResponseEntity(userServicesImpl.getUsersById(id), HttpStatus.OK);

    }

    @RequestMapping(value  = "/users/up",method = RequestMethod.PUT)
    public Integer updateUsersById(@RequestBody Users users) {

        return userServicesImpl.updateUsersById(users);
    }

    @RequestMapping(value  = "/users/{id}",method = RequestMethod.DELETE)
    public Integer deleteUsersById(@PathVariable int id) {

        return userServicesImpl.deleteUsersById(id);
    }

}
