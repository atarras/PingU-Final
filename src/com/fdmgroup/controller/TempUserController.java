package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Admin;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Trainee;

@Controller
public class TempUserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String getUsersPage(HttpServletRequest req) {
		
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
		
		return "users";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String updateUser() {
		return "users";
	}
}
