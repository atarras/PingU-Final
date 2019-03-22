package com.fdmgroup.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Trainee;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@fdmgroup.com$");
	
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
		
//		UserDAO userDAO = new UserDAO();
		IUser loginUser = userDAO.loginUser(username, password);
//		if(loginUser==null)
//		{
//			session.setAttribute("usernameIncorrect", true);
//			session.setAttribute("passwordIncorrect", true);
//			return "login";
//		}
		
		if (loginUser==null) {
			session.setAttribute("passwordIncorrect", true);
			return "login";
		} 
		session.setAttribute("newUser", loginUser);
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
	public String signup(HttpServletRequest req,Model model, @ModelAttribute(value="newUser") Consultant user, BindingResult br,
			RedirectAttributes redirectAttributes,
			@RequestParam("title") String jobTitle,
			@RequestParam("employer") String employer) {
		
		System.out.println("POST Consultant");
		
		String email = user.getEmail().toLowerCase();
		if(!pattern.matcher(email).find()){
			System.out.println("invalid email");
			/* TODO: add error messageInvalid EMAIL */
			return null; // add the correct view string
		}
		
		if (!br.hasErrors()) {
			user.setCurrentTitle(jobTitle);
			user.setEmployer(employer);
			//System.out.println(user);
			
			IUser newUser = userDAO.create(user);
			req.setAttribute("userId", newUser.getUserId());
			model.addAttribute("newUser", user);
			redirectAttributes.addFlashAttribute("userId", newUser.getUserId());
			/* TODO: write Consultant to DB */
			
		}
		
		return "redirect:/signUpRequest";
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
	public String signup(HttpServletRequest req,Model model, @ModelAttribute(value="newUser") Trainee user, BindingResult br,
			RedirectAttributes redirectAttributes,
			@RequestParam("stream") String stream) {
		
		System.out.println("POST Trainee");
		
		String email = user.getEmail().toLowerCase();
		if(!pattern.matcher(email).find()){
			System.out.println("invalid email");
			/* TODO: add error messageInvalid EMAIL */
			return null; // add the correct view string
		}
		
		if (!br.hasErrors()) {
			user.setStream(stream);
			//System.out.println(user);
			
			/* TODO: write Trainee to DB */
			IUser newUser = userDAO.create(user);
			model.addAttribute("newUser", user);
			redirectAttributes.addFlashAttribute("userId", newUser.getUserId());
		}
		
		return "redirect:/signUpRequest";
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.POST)
	public String logOut(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.removeAttribute("newUser");
		session.invalidate();
		req.setAttribute("infoMsg", "logged out");
		/* TODO: add the correct view string*/
		return null;

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
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String showSearch() {
		return "searchFile";
	}	
	
}
