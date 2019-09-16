package com.example.serviceimpl;

import java.util.List;

import com.example.daoimpl.UsersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dto.Users;
import com.example.services.UserServices;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	UsersDaoImpl usersDaoImpl = new UsersDaoImpl();

	@Override
	public Boolean saveUsers(Users users) {

		return usersDaoImpl.saveUser(users);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUsers() {

		return usersDaoImpl.getAllUsers();
	}

	@Override
	public Users getUsersById(int id) {

		return usersDaoImpl.getUsersById(id);
	}

	@Override
	public Integer deleteUsersById(int id) {

		return usersDaoImpl.deleteUsersById(id);
	}

	@Override
	public Integer updateUsersById(Users users) {
		return usersDaoImpl.updateUser(users);
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "fb";
	}
}
