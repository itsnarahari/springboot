package com.example.util;


import com.example.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRowMappers implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer users = new Customer();
        users.setId(rs.getInt("id"));
        users.setName(rs.getString("name"));
        users.setEmail(rs.getString("email"));
        users.setMobile(rs.getString("mobile"));

        return users;
    }
}
