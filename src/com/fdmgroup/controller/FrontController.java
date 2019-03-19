package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {
	
	@RequestMapping("/")
	public String showIndex() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
	
}
