package com.fdmgroup.controller;

import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fdmgroup.DAO.MessagesDAO;
import com.fdmgroup.DAO.RequestDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Admin;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Messages;
import com.fdmgroup.model.Request;
import com.fdmgroup.model.Trainee;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RequestDAO requestDao;
	
	@Autowired
	private MessagesDAO messagesDao;
	
	Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@fdmgroup.com$");
	
	@RequestMapping("/")
	public ModelAndView showIndex() {
		return new ModelAndView("redirect:/login");
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
			HttpServletRequest req, Model model) {
		
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
			session.setAttribute("incorrectCredential", true);
			model.addAttribute("newUser", new IRUser());
			return "login";
		} 
		
		if (!loginUser.isStatus()){
			session.setAttribute("inactiveUser", true);
			model.addAttribute("newUser", new IRUser());
			return "login";
		}
		
		session.setAttribute("newUser", loginUser);
		
		if(loginUser instanceof Admin){
			List<Request> pendingRequests = requestDao.findAllPendingRequests();
			req.setAttribute("pendingRequests", pendingRequests);
			return "request";
		} else {
			
			if(loginUser.getGroup()!=null){
			List<Messages> allMessagesForGroup = messagesDao.getAllMessagesForGroup(loginUser.getGroup().getGroupId());
			if(allMessagesForGroup!=null && allMessagesForGroup.size()>=1)
				req.setAttribute("groupMessages", allMessagesForGroup);
			}
			List<Messages> allMessagesForUser = messagesDao.getAllMessagesForUser(loginUser.getUserId());
			if(allMessagesForUser!=null && allMessagesForUser.size()>=1)
			session.setAttribute("userMessages", allMessagesForUser);
			
			return "home";
		}
	}
	
	private void removeErrorAttributes(HttpSession session) {
		session.removeAttribute("incorrectCredential");
		session.removeAttribute("inactiveUser");
		session.removeAttribute("userSignUp");
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
		HttpSession session = req.getSession();
		
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
			session.setAttribute("userSignUp", true);
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
		HttpSession session = req.getSession();
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
			session.setAttribute("userSignUp", true);
		}
		
		return "redirect:/signUpRequest";
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(HttpServletRequest req, Model model){
		HttpSession session = req.getSession();
		session.removeAttribute("newUser");
		System.out.println("logged out");
		session.invalidate();
		req.setAttribute("infoMsg", "logged out");
		/* TODO: add the correct view string*/
		return "redirect:/login";

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
