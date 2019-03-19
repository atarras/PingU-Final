package com.fdmgroup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.IUser;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String showIndex() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String getLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		removeErrorAttributes(session);
		return "login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest req) {
		
		System.out.println("/login/POST?username=" + username +
			"&password=" + password);
		
		
		HttpSession session = req.getSession();
		removeErrorAttributes(session);
		
		UserDAO userDAO = new UserDAO();
		IUser loginUser = userDAO.loginUser(username, password);
//		if(loginUser==null)
//		{
//			session.setAttribute("usernameIncorrect", true);
//			session.setAttribute("passwordIncorrect", true);
//			return "login";
//		}
		
		if (loginUser==null) {
			session.setAttribute("usernameIncorrect", true);
			return "login";
		} else if (!password.equals(loginUser.getPassword())) {
			session.setAttribute("passwordIncorrect", true);
			return "login";
		}
		
		return "home";
	}
	
	private void removeErrorAttributes(HttpSession session) {
		session.removeAttribute("passwordIncorrect");
		session.removeAttribute("usernameIncorrect");
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(
			@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("city") String city,
			@RequestParam("country") String country,
			@RequestParam("linkedin") String linkedin,
			@RequestParam("usertype") String userType
			) {
		
		System.out.println("/signup/POST?firstname=" + firstName +
				"&lastname=" + lastName +
				"&username=" + username +
				"&password=" + password +
				"&email=" + email +
				"&city=" + city +
				"&country=" + country +
				"&linkedin=" + linkedin +
				"&usertype=" + userType);
		
		return "login";
	}
	
}
