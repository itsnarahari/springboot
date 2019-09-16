package com.example.services;

import java.util.List;

import com.example.dto.Users;

public interface UserServices {

	public Boolean saveUsers(Users users);
	public List<Users> getAllUsers();
	public Users getUsersById(int id);
	public Integer deleteUsersById(int id);
	public Integer updateUsersById(Users users);
	public String test();

}
