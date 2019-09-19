package com.example.services;

import java.util.List;

import com.example.dto.Users;
import org.json.JSONObject;

public interface UserServices {

	public String saveUser(Users users);
	public boolean isEmailExist(String mail);
	public List<Users> getAllUsers();
	public Users getUsersById(int id);
	public Integer deleteUsersById(int id);
	public Integer updateUsersById(Users users);
	public String test();

}
