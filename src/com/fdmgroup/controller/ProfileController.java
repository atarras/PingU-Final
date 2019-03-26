package com.fdmgroup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;

@Controller
public class ProfileController
{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/{userID}", method=RequestMethod.GET)
	public String getUserProfile(HttpServletRequest req, Model model, @PathVariable("userID") long id)
	{
		IRUser profileUser = (IRUser)userDAO.findUserById(id);
		req.setAttribute("profileUser", profileUser);
		return "profile";
	}
	
	@RequestMapping(value="/{userID}", method=RequestMethod.POST)
	public String setUserProfile(HttpServletRequest req, Model model, @PathVariable("userID") long id, @RequestParam("country") String newCountry,
			@RequestParam("city") String newCity, @RequestParam("phone") String newPhone)
	{
		IRUser profileUser = (IRUser)userDAO.findUserById(id);
		
		if(!newCountry.equals(""))
		{
			profileUser.setCountry(newCountry);
			userDAO.changeCountry(profileUser.getUserId(), newCountry);
		}
		if(!newCity.equals(""))
		{
			profileUser.setCity(newCity);
			userDAO.changeCity(profileUser.getUserId(), newCity);
		}
		if(!newPhone.equals(""))
		{
			profileUser.setPhoneNumber(newPhone);
			userDAO.updatePhoneNumber(profileUser.getUserId(), newPhone);
		}
		req.getSession().setAttribute("newUser", profileUser);
		
		return "profile";
	}
	
	@RequestMapping(value="/password", method=RequestMethod.POST)
		public String updateSecurity(HttpServletRequest req,
				@RequestParam("current-password") String currentPassword, @RequestParam("new-password") String newPassword,
				@RequestParam("security-answer") String securityAnswer) {
			IUser user = (IUser) req.getSession().getAttribute("newUser");
			
			if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
				req.setAttribute("errorPassword", "Invalid Password.");
				System.out.println("WRONG");
				
				if(!securityAnswer.equals(""))
				{
					userDAO.changeSecurityAnswer(user.getUserId(), securityAnswer);
					
					if(newPassword.equals(""))
					{
						return "profile";
					}
				}
				
				return "profile"; // add the correct view string
			}
			
			if (passwordEncoder.matches(newPassword, user.getPassword())) {
				req.setAttribute("errorPassword", "Invalid Password.");
				System.out.println("SAME");
				return "profile"; // add the correct view string
			}
			
			req.getSession().setAttribute("newUser", user);
				userDAO.updatePassword(user.getUserId(), newPassword);
				req.setAttribute("successPassword", "Password updated.");
				System.out.println("SUCCESS");
				return "profile"; // add the correct view string
			}
}
