package com.example.daoimpl;

import com.example.dao.PlanetDAO;
import com.example.dto.Planets;
import com.example.util.PlanetsRowMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Types;
import java.util.List;

@Repository
@NoArgsConstructor
public class PlanetDaoImpl implements PlanetDAO {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public Planets savePlanets(@RequestBody Planets planets) {

        String query = String.format("insert into planets(name,distance)values('%s','%d')", planets.getName(), planets.getDistance());

        jdbcTemplate.update(query);
        return planets;
    }

    @Override
    public Integer updatePlanets(Planets planets) {

        String query = "update planets set name=?,distance=? where id=?";
        Object[] params = {planets.getName(),planets.getDistance(),planets.getId()};
        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query,params,types);
    }

    @Override
    public Integer deletePlanetById(int id) {
        return jdbcTemplate.update("delete from planets where id=?",id);    }

    @Transactional
    @Override
    public List<Planets> getAllPlanets() {

        return jdbcTemplate.query("select * from planets", new PlanetsRowMapper());
    }

    @Override
    public Planets getPlanetsById(int id) {

        String sql = "SELECT * FROM user WHERE id=?";

        try
        {
            return (Planets) this.jdbcTemplate.queryForObject(sql,new Object[] {id}, new PlanetsRowMapper());
        }
        catch (EmptyResultDataAccessException em)
        {
            return null;
        }
    }
}
