package com.example.daoimpl;

import com.example.dao.UsersDAO;
import com.example.dto.Users;
import com.example.util.UsersRowMappers;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
@NoArgsConstructor
public class UsersDaoImpl implements UsersDAO {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public Boolean saveUser(Users user){
        String query="insert into users values(?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){

            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1,user.getName());
                ps.setString(2,user.getEmail());
                ps.setString(3,user.getMobile());

                return ps.execute();

            }
        });
    }

    @Override
    public Integer updateUser(Users users) {

        String query = "update planets set name=?,distance=? where id=?";
        Object[] params = {users.getName(), users.getEmail(), users.getMobile()};
        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query,params,types);
    }

    @Override
    public Integer deleteUsersById(int id) {
        return jdbcTemplate.update("delete from planets where id=?",id);
    }

    @Transactional
    @Override
    public List<Users> getAllUsers() {

        return jdbcTemplate.query("select * from planets", new UsersRowMappers());
    }

    @Override
    public Users getUsersById(int id) {

        String sql = "SELECT * FROM user WHERE id=?";

        try
        {
            return (Users) this.jdbcTemplate.queryForObject(sql,new Object[] {id}, new UsersRowMappers());
        }
        catch (EmptyResultDataAccessException em)
        {
            return null;
        }
    }

}
