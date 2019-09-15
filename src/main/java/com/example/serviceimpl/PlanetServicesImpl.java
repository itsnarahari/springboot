package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.example.daoimpl.PlanetDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dto.Planets;
import com.example.services.PlanetServices;
import org.springframework.stereotype.Service;

@Service
public class PlanetServicesImpl implements PlanetServices {

	@Autowired
    PlanetDaoImpl planetDaoimpl = new PlanetDaoImpl();

	@Override
	public Planets savePlanets(Planets planets) {
		planetDaoimpl.savePlanets(planets);
		return planets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Planets> getAllPlanets() {

		return planetDaoimpl.getAllPlanets();
	}

	@Override
	public Planets getPlanetsById(int id) {

		return planetDaoimpl.getPlanetsById(id);
	}

	@Override
	public String deletePlanetsById(int id) {
		return null;
	}

	@Override
	public Integer deletePlanetById(int id) {

		planetDaoimpl.deleteById(id);
		return 1;
	}

	@Override
	public String updatePlanetsById(int id) {
		return null;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "fb";
	}
}
