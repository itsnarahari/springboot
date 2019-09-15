package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import com.example.dto.Planets;
import com.example.services.PlanetServices;

public class PlanetServicesImpl implements PlanetServices {

	
	List planetList = new ArrayList();
	

	@Override
	public Planets savePlanets(Planets planets) {
		
//		planets.setId(25);
//		planets.setName("Moon");
		return planets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Planets> getAllPlanets() {
		
		planetList.add(new Planets(1,"Moon"));
		planetList.add(new Planets(2,"Jupitar"));
		planetList.add(new Planets(3,"Earth"));
		
		return planetList;
	}

	@Override
	public String deletePlanetsById(int id) {
		return null;
	}

	@Override
	public String updatePlanetsById(int id) {
		return null;
	}
	
	@Override
	public Planets getPlanetsById(int id) {
		
		Predicate<Planets>  byId = p -> p.getId()==id;
		
		return filtersPlanets(byId);	
	}
	
	private Planets filtersPlanets(Predicate<Planets> predicate)
	{
		return getAllPlanets().stream().filter(predicate).findFirst().orElse(null);
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "fb";
	}
	
	

}
