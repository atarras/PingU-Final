package com.fdmgroup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Trainee;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String showIndex() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String getLogin(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		removeErrorAttributes(session);
		
		model.addAttribute("newUser", new IRUser());
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
	
	/**
	 * Sign up a Consultant via Spring Form plus a few extra fields
	 * @param model
	 * @param user
	 * @param br
	 * @param jobTitle
	 * @param employer
	 * @return
	 */
	@RequestMapping(value="/signup-c", method=RequestMethod.POST)
	public String signup(Model model, @ModelAttribute(value="newUser") Consultant user, BindingResult br,
			@RequestParam("title") String jobTitle,
			@RequestParam("employer") String employer) {
		
		System.out.println("POST Consultant");
		
		if (!br.hasErrors()) {
			user.setCurrentTitle(jobTitle);
			user.setEmployer(employer);
			System.out.println(user);
			
			/* TODO: write Consultant to DB */
			
		}
		
		return "login";
	}
	
	/**
	 * Sign up a Trainee via Spring Form plus a few extra fields
	 * @param model
	 * @param user
	 * @param br
	 * @param stream
	 * @return
	 */
	@RequestMapping(value="/signup-t", method=RequestMethod.POST)
	public String signup(Model model, @ModelAttribute(value="newUser") Trainee user, BindingResult br,
			@RequestParam("stream") String stream) {
		
		System.out.println("POST Trainee");
		
		if (!br.hasErrors()) {
			user.setStream(stream);
			System.out.println(user);
			
			/* TODO: write Trainee to DB */
			
		}
		
		return "login";
	}
	
	// TODO: move this to appropriate controller
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String getUsersPage() {
		
		return "users";
	}
	
	/*@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(
			@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("city") String city,
			@RequestParam("country") String country,
			@RequestParam("linkedin") String linkedin,
			@RequestParam("usertype") String userType,
			@RequestParam("stream") String stream,
			@RequestParam("title") String jobTitle,
			@RequestParam("employer") String employer
			) {
		
		System.out.println("/signup/POST?firstname=" + firstName +
				"&lastname=" + lastName +
				"&username=" + username +
				"&password=" + password +
				"&email=" + email +
				"&city=" + city +
				"&country=" + country +
				"&linkedin=" + linkedin +
				"&usertype=" + userType +
				"&stream=" + stream +
				"&title=" + jobTitle +
				"&employer=" + employer
				);
		
		return "login";
	}*/
	
}
