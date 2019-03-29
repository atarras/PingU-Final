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
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.enums.Employer;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;

@Controller
public class ProfileController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/{userID}", method = RequestMethod.GET)
	public String getUserProfile(HttpServletRequest req, Model model, @PathVariable("userID") long id) {
		HttpSession session = req.getSession();
		session.removeAttribute("successPassword");
		session.removeAttribute("samePassword");
		session.removeAttribute("errorPassword");
		session.removeAttribute("newAnswer");
		session.removeAttribute("successEmployerRequest");
		session.removeAttribute("successRoleRequest");
		session.removeAttribute("errorRoleRequest");
		session.removeAttribute("errorEmployerRequest");
		IRUser profileUser = (IRUser) userDAO.findUserById(id);
		
		
		if(profileUser.getGroup() != null){
			String username = profileUser.getUsername();
			profileUser = (IRUser) userDAO.findByUsernameWithGroup(username);			
		}
		model.addAttribute("employers", Employer.values());
		session.setAttribute("profileUser", profileUser);
		return "profile";
	}

	@RequestMapping(value = "/{userID}", method = RequestMethod.POST)
	public ModelAndView setUserProfile(HttpServletRequest req, Model model, @PathVariable("userID") long id,
			@RequestParam("country") String newCountry, @RequestParam("city") String newCity,
			@RequestParam("phone") String newPhone) {
		IRUser profileUser = (IRUser) userDAO.findUserById(id);

		if (!newCountry.equals("")) {
			profileUser.setCountry(newCountry);
			userDAO.changeCountry(profileUser.getUserId(), newCountry);
		}
		if (!newCity.equals("")) {
			profileUser.setCity(newCity);
			userDAO.changeCity(profileUser.getUserId(), newCity);
		}
		if (!newPhone.equals("")) {
			profileUser.setPhoneNumber(newPhone);
			userDAO.updatePhoneNumber(profileUser.getUserId(), newPhone);
		}
		model.addAttribute("employers", Employer.values());
		req.getSession().setAttribute("newUser", profileUser);

		return new ModelAndView("redirect:/"+id);
	}

	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public String updateSecurity(HttpServletRequest req, @RequestParam("current-password") String currentPassword,
			@RequestParam("new-password") String newPassword, @RequestParam("security-answer") String securityAnswer) {
//		IUser user = (IUser) req.getSession().getAttribute("newUser");
		HttpSession session = req.getSession();
		IUser user = (IUser)session.getAttribute("newUser");
		session.removeAttribute("errorPassword");
		session.removeAttribute("samePassword");
		session.removeAttribute("successPassword");
		session.removeAttribute("successEmployerRequest");
		session.removeAttribute("successRoleRequest");
		session.removeAttribute("errorRoleRequest");
		session.removeAttribute("errorEmployerRequest");
		
		if(passwordEncoder.matches(currentPassword, user.getPassword())){
			if(!securityAnswer.equals("")){
				userDAO.changeSecurityAnswer(user.getUserId(), securityAnswer);
				session.setAttribute("newAnswer", true);
			}
			
			if(!newPassword.equals("")){
				if(passwordEncoder.matches(newPassword, user.getPassword())){
					
					session.setAttribute("samePassword", true);
				}
				else{
					IUser updatedUser = userDAO.updatePassword(user.getUserId(), newPassword);
					session.setAttribute("successPassword", true);
					session.setAttribute("newUser", updatedUser);
				}
			}
			
		}
		else{
			session.setAttribute("errorPassword", true);
			System.out.println("WRONG");
		}
		
		
		return "profile";

//		if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
//			session.setAttribute("errorPassword", true);
//			System.out.println("WRONG");
//			if (!securityAnswer.equals("")) {
//				userDAO.changeSecurityAnswer(user.getUserId(), securityAnswer);
//
//				if (newPassword.equals("")) {
//					session.setAttribute("newAnswer", true);
//					return "profile";
//				}
//			}
//
//		} else {
//
//			if (passwordEncoder.matches(newPassword, user.getPassword())) {
//				session.setAttribute("samePassword", true);
//				System.out.println("SAME");
//				// return "profile"; // add the correct view string
//			} else {
//				// return "profile"; // add the correct view string
//
//				req.getSession().setAttribute("newUser", user);
//				userDAO.updatePassword(user.getUserId(), newPassword);
//				session.setAttribute("successPassword", true);
//				System.out.println("SUCCESS");
//				// return "profile"; // add the correct view string
//			}
//		}
//		return "profile";
	}
}
