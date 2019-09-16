package com.example.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Users;
import com.example.serviceimpl.UserServicesImpl;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    UserServicesImpl userServicesImpl = new UserServicesImpl();

    @RequestMapping(value = "/planets/add",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
    public ResponseEntity<String> createUser(@RequestBody Users users) throws SQLIntegrityConstraintViolationException {
        if (userServicesImpl.getUsersById(users.getId()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ users.getId(), HttpStatus.IM_USED);
        }
        userServicesImpl.saveUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @RequestMapping(value = "/planets")
    public List<Users> getAllPlanets() {
        return userServicesImpl.getAllUsers();
    }

    @RequestMapping("/planets/{id}")
    public Users getPlanetById(@PathVariable int id) {

        return userServicesImpl.getUsersById(id);
    }

    @RequestMapping("/planets/{id}")
    public Integer updatePlanetById(Users users) {

        return userServicesImpl.updateUsersById(users);
    }

    @RequestMapping("/planets/{id}")
    public Integer deletePlanetById(@PathVariable int id) {

        return userServicesImpl.deleteUsersById(id);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
