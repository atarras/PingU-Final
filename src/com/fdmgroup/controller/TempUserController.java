package com.fdmgroup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Admin;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Trainee;

@Controller
public class TempUserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String getUsersPage(HttpServletRequest req, Model model) {
		
		/*UserDAO uDAO = new UserDAO();
		List<IUser> users = uDAO.getAllUsers();
		System.out.println(users);
		req.getSession().setAttribute("users", users);*/
		//getAllUsers(req);
		/*System.out.println(req.getSession().getAttribute("users"));*/
		
		
		/* Set session attribute for all Trainees */
		//getUserByType(req, Trainee.class);
		
		List<Trainee> trainees = new ArrayList<>();
		for (IUser user : userDAO.getUserByType(Trainee.class)) {
			if (user instanceof Trainee) trainees.add((Trainee) user);
		}
		
		req.getSession().setAttribute("trainees", trainees);
		
		/* Set session attribute for all Consultants */
		req.getSession().setAttribute("consultants", userDAO.getUserByType(Consultant.class));
		
		/* Set session attribute for all Admins */
		req.getSession().setAttribute("admins", userDAO.getUserByType(Admin.class));
		
		model.addAttribute("newTrainee", new Trainee());
		
		return "users";
	}
	
	@RequestMapping(value="/trainee", method=RequestMethod.POST)
	public ModelAndView createTrainee(HttpServletResponse res, Model model, @ModelAttribute(value="newTrainee") Trainee user, BindingResult br) {
		System.out.println("/trainee");
		
		if (!br.hasErrors()) {
			/*System.out.println(user);*/
			
			/* Write Trainee to DB */
			userDAO.create(user);
		}
		
		return new ModelAndView("redirect:/users");
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ModelAndView postUser() {
		System.out.println("/user/POST");
		
		/* If we are passed in an id, update that user */
		
		
		/* Otherwise create a new user with the given parameters */
		
		/* We can determine the type of user to create passed on whether certain parameters are empty */
		
		
		return new ModelAndView("redirect:/users");
	}
	

}
