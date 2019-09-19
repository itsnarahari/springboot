package com.example.daoimpl;

import com.example.dao.UsersDAO;
import com.example.dto.Users;
import com.example.util.UsersRowMappers;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
@Service
@Configuration
@Transactional
public class UsersDaoImpl implements UsersDAO {


	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String saveUser(Users users)
    {

        String query="insert into users(name,email,mobile) values(?,?,?)";

        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, users.getName());
                ps.setString(2, users.getEmail());
                ps.setString(3, users.getMobile());
                return ps;
            }
        }, holder);

        Long genid = holder.getKey().longValue();
        return String.valueOf(genid);

    }
    @Override
    public Integer updateUser(Users users) {

        String query = "update users set name=?,email=?,mobile=? where id=?";

        return jdbcTemplate.update(query,users.getName(),users.getEmail(),users.getMobile(),users.getId());
    }

    @Override
    public Integer deleteUsersById(int id) {

        return jdbcTemplate.update("delete from users where id=?",id);
    }

    @Override
    public boolean isEmailExist(String mail)
    {
        String sql = "SELECT count(*) FROM users WHERE email=?";

        boolean result = false;
        int count = jdbcTemplate.queryForObject(sql, new Object[] { mail }, Integer.class);
        if (count > 0) {
            result = true;
        }
        return result;
    }

    @Transactional
    @Override
    public List<Users> getAllUsers() {

        return jdbcTemplate.query("select * from users", new UsersRowMappers());
    }

    @Override
    public Users getUsersById(int id) {

        String sql = "SELECT * FROM users WHERE id=?";
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
