package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dao.UserRepository;
import com.example.model.User;

@Service
public class TravelService {
	@Autowired	
	private UserRepository userRepository;
	
	public void addUser(User user){
		userRepository.save(user);
	}
	
	public void userLogin(User user) throws Exception{
		
		if(null == user.getUsername() && user.getUsername().isEmpty()) {
			throw new Exception("Mandatory field");
		}
		if(null == user.getPassword() && user.getPassword().isEmpty()) {
			throw new Exception("Mandatory field");
		}
		
		if(null != user.getUsername() && !user.getUsername().isEmpty() && null != user.getPassword() && !user.getPassword().isEmpty()) {
			if("Admin".equalsIgnoreCase(user.getUsername()) && "Admin".equalsIgnoreCase(user.getPassword())) {
				
			}else {
				throw new Exception("Invalid Credentials");
			}
		}
		
	}

}
