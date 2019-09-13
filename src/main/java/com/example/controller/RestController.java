package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Planets;
import com.example.serviceimpl.PlanetServicesImpl;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
    PlanetServicesImpl planetServicesImpl = new PlanetServicesImpl();
    
    Planets Planets = new Planets();
	@RequestMapping("/planets/add")
	public Planets addPlanets(@RequestBody Planets planets)
	{
		return planetServicesImpl.savePlanets(planets);
			
	}
	@RequestMapping("/planets")
	public List<Planets> getAllPlanets()
	{
		return planetServicesImpl.getAllPlanets();
	}
	@RequestMapping("/planets/{id}")
	public ResponseEntity<Planets> getPlanetById(@PathVariable int id)
	{
		Planets = planetServicesImpl.getPlanetsById(id);
		
		if(Planets== null)
		{
			return new ResponseEntity<Planets>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Planets>(HttpStatus.OK);
	}

	@RequestMapping("/")
	public String hello()
	{
		return planetServicesImpl.test();
	}
}
