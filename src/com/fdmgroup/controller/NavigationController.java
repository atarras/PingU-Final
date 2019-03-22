package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;

@Controller
public class NavigationController
{
	
	/*Currently these are simple redirect methods to all pages*/
	
		
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String showSearch() {
		return "search";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String showProfile() {
		return "profile";
	}	
	
	@RequestMapping(value="/group", method=RequestMethod.GET)
	public String showGroup() {
		return "group";
	}	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String showHome() {
		return "home";
	}	
	
	//this will be handled by logincontroller, remove later, here for testing purposes
	@RequestMapping(value="/logouttest", method=RequestMethod.GET)
	public String showLogout(Model model) {
		model.addAttribute("newUser", new IRUser());
		return "login";
	}	
}
