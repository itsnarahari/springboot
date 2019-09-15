package com.example.util;


import com.example.dto.Planets;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanetsRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Planets planets = new Planets();
        planets.setId(rs.getInt("id"));
        planets.setName(rs.getString("name"));
        planets.setDistance(rs.getInt("id"));
        return planets;
    }
}
