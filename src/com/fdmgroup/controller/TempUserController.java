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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.helpers.StringHelpers;
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
	public void postUser(HttpServletResponse res,
			@RequestParam("id") String stringID,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("city") String city,
			@RequestParam("country") String country,
			@RequestParam("description") String description,
			@RequestParam("stream") String stream,
			@RequestParam("security-answer") String securityAnswer,
			@RequestParam("visibility") String visibility,
			@RequestParam("status") String statusString,
			@RequestParam(value="title", required=false) String jobTitle
			) {
		System.out.println("/user/POST?id=" + stringID +
				"&firstName=" + firstName +
				"&lastName=" + lastName +
				"&username=" + username +
				"&password=" + password +
				"&email=" + email +
				"&phone=" + phone +
				"&city=" + city +
				"&country=" + country +
				"&description=" + description +
				"&stream=" + stream +
				"&security-answer=" + securityAnswer +
				"&visibility=" + visibility +
				"&status=" + statusString +
				"&title=" + jobTitle
				);
		
		long id = Long.parseLong(stringID);
		
		IUser foundUser = userDAO.findUserById(id);
		if (foundUser != null) {
			System.out.println("Found");
			
			
			
		} else {
			// return error message or page
		}
		
		if (foundUser instanceof IRUser) {
			System.out.println("is IRUser");
			/* TODO: update first name */
			
			/* TODO: update last name */
			
			/* TODO: update email */
			
			if (StringHelpers.isData(phone)) userDAO.updatePhoneNumber(id, phone);
			if (StringHelpers.isData(city)) userDAO.changeCity(id, city);
			if (StringHelpers.isData(country)) userDAO.changeCountry(id, country);
			if (StringHelpers.isData(description)) userDAO.updateDescription(id, description);
			
			if (StringHelpers.isData(statusString)) {
				boolean status = Boolean.parseBoolean(statusString);
				if (status) {
					userDAO.activateUser(id);
				} else {
					userDAO.delete(id);
				}
			}
			
			if (StringHelpers.isData(visibility)) {
				userDAO.changeVissibility(id, Boolean.parseBoolean(visibility));
			}
		}
		
		if (foundUser instanceof Trainee) {
			/* update stream */
			
		}
		
		if (foundUser instanceof Consultant) {
			//userDAO.updateJobTitle(id, jobTitle);
		}
		
		/* If we are passed in an id, update that user */
		
		
		/* Otherwise create a new user with the given parameters */
		
		/* We can determine the type of user to create passed on whether certain parameters are empty */
		res.setContentType("text/html;charset=UTF-8");
        try {
			res.getWriter().write("/PingU/users");  // TODO: make this not hardcoded
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return new ModelAndView("redirect:/users");
	}
	
	// We don't need to delete in our app
	/*@RequestMapping(value="/user", method=RequestMethod.DELETE)
	public ModelAndView deleteUser(@RequestParam("id") String id) {
		System.out.println("/user/DELETE?id=" + id);
		
		
		
		return new ModelAndView("redirect:/users");
	}*/
	

}
