package com.example.TuneHubApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHubApp.entities.Users;
import com.example.TuneHubApp.repositories.UserRepository;
@Service
public class UsersServiceImplementation implements UsersService 
{
	@Autowired
    UserRepository uservt;
	@Override
	public String addUser(Users user) {
		uservt.save(user);
		return "registersuccess";
	}
	@Override
	public boolean emailExists(String email) {
		if(uservt.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
		Users user=uservt.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String getRole(String email) {
		return(uservt.findByEmail(email).getRole());
	}
	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return uservt.findByEmail(email);
	}
	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		uservt.save(user);
		
	}

}
