package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Planets;
import com.example.serviceimpl.PlanetServicesImpl;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.attribute.standard.Media;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    PlanetServicesImpl planetServicesImpl = new PlanetServicesImpl();

    @RequestMapping(value = "/planets/add",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
    public Planets savePlanets(@RequestBody Planets planets) {

        return planetServicesImpl.savePlanets(planets);
    }
    @RequestMapping("/planets")
    public List<Planets> getAllPlanets() {
        return planetServicesImpl.getAllPlanets();
    }

    @RequestMapping("/planets/{id}")
    public Planets getPlanetById(@PathVariable int id) {

        return planetServicesImpl.getPlanetsById(id);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
