package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.UserDAO;

@Controller
public class UserController {
	UserDAO userDAO = new UserDAO();
	
	@RequestMapping(value="/deactivateUser", method=RequestMethod.POST)
	public String deactivateUser(@RequestParam("userID") Long userID){
		
		userDAO.delete(userID);
		
		return null;				//add the correct view string
	}
	
	@RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String activateUser(@RequestParam("userID") Long userID){
		userDAO.activateUser(userID);
		
		return null;				//add the correct view string
	}

	
	@RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String get(@RequestParam("userID") Long userID){
		userDAO.activateUser(userID);
		
		return null;				//add the correct view string
	}
}
