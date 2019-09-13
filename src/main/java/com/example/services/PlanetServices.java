package com.example.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.dto.Planets;

public interface PlanetServices {
	
	public Planets savePlanets(Planets planets);
	public List<Planets> getAllPlanets();
	public Planets getPlanetsById(int id);
	public String deletePlanetsById(int id);
	public String updatePlanetsById(int id);
	public String test();

}
