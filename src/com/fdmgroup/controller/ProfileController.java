package com.fdmgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
	
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.IRUser;

@Controller
public class ProfileController
{
	@Autowired
	private UserDAO userDAO;
	@RequestMapping(value="/{userID}", method=RequestMethod.GET)
	public String getUserProfile(Model model, @PathVariable("userID") long id)
	{
		IRUser profileUser = (IRUser)userDAO.findUserById(id);
		model.addAttribute("profileUser", profileUser);
		
		return "profile";
	}
}
