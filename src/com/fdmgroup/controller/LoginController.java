package com.fdmgroup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		// TODO: Remove placeholder
		if (!username.equals("admin")) {
			session.setAttribute("usernameIncorrect", true);
			return "login";
		} else if (!password.equals("123")) {
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
