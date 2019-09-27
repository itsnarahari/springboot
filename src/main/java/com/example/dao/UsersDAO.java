package com.example.dao;

import com.example.dto.Users;
import org.json.JSONObject;

import java.util.List;

public interface UsersDAO {

    public String saveUser(Users users);
    public List<Users> getAllUsers();
    public Users getUsersById(int id);
    public Integer updateUser(Users users);
    public Integer deleteUsersById(int id);
    public boolean isEmailExist(String mail);

}
