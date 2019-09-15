package com.example.dao;

import com.example.dto.Planets;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface PlanetDAO {

    public Planets savePlanets(Planets planets);
    public List<Planets> getAllPlanets();
    public Planets getPlanetsById(int id);
    public Integer updatePlanets(Planets planets);
    public Integer deletePlanetById(int id);
}
