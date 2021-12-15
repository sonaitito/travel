package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.TravelService;

@ComponentScan
@RestController
public class TravelServiceController {
	
	@Autowired
	private TravelService travelService;
	
	@PostMapping(value="/userlogin" , produces = {"application/json"} , consumes = {"application/json"})
	public void userLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody User user ) throws Exception{
		this.travelService.userLogin(user);
	}

	@PostMapping(value="/addUserNew")
	public void addUser(@RequestBody User user ){
		System.out.println("inside adduser");
		travelService.addUser(user);
	}
	
}
