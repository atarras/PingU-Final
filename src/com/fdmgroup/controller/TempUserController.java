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
		
		List<IUser> users = null;
		
		/* Set session attribute for all Trainees */
		List<Trainee> trainees = new ArrayList<>();
		users = userDAO.getUserByType(Trainee.class);
		if (users != null) {
			for (IUser user : users) {
				if (user instanceof Trainee) trainees.add((Trainee) user);
			}
		}
		req.getSession().setAttribute("trainees", trainees);
		
		/* Set session attribute for all Consultants */
		List<Consultant> consultants = new ArrayList<>();
		users = userDAO.getUserByType(Consultant.class);
		if (users != null) {
			for (IUser user : users) {
				if (user instanceof Consultant) consultants.add((Consultant) user);
			}
		}
		req.getSession().setAttribute("consultants", consultants);
		
		/* Set session attribute for all Admins */
		List<Admin> admins = new ArrayList<>();
		users = userDAO.getUserByType(Admin.class);
			if (users != null) {
			for (IUser user : users) {
				if (user instanceof Admin) admins.add((Admin) user);
			}
		}
		req.getSession().setAttribute("admins", admins);
		
		/* Prepare model with a Trainee so we can create one if needed */
		model.addAttribute("newTrainee", new Trainee());
		
		/* Prepare model with a Consultant so we can create one if needed */
		model.addAttribute("newConsultant", new Consultant());
		
		/* Prepare model with an Admin so we can create one if needed */
		model.addAttribute("newAdmin", new Admin());
		
		if (req.getSession().getAttribute("pageContext") == null) req.getSession().setAttribute("pageContext", "trainee");
		return "users";
	}
	
	/**
	 * Create new Trainee
	 * @param res
	 * @param model
	 * @param user
	 * @param br
	 * @return
	 */
	@RequestMapping(value="/trainee", method=RequestMethod.POST)
	public ModelAndView createTrainee(HttpServletRequest req, HttpServletResponse res, Model model, @ModelAttribute(value="newTrainee") Trainee user, BindingResult br) {
		System.out.println("/trainee");
		
		if (!br.hasErrors()) {
			/* Write Trainee to DB */
			userDAO.create(user);
		}
		req.getSession().setAttribute("pageContext", "trainee");
		return new ModelAndView("redirect:/users");
	}
	
	/**
	 * Create new Consultant
	 * @param res
	 * @param model
	 * @param user
	 * @param br
	 * @return
	 */
	@RequestMapping(value="/consultant", method=RequestMethod.POST)
	public ModelAndView createConsultant(HttpServletRequest req, HttpServletResponse res, Model model, @ModelAttribute(value="newConsultant") Consultant user, BindingResult br) {
		System.out.println("/consultant");
		
		if (!br.hasErrors()) {
			/* Write Consultant to DB */
			userDAO.create(user);
		}
		req.getSession().setAttribute("pageContext", "consultant");
		return new ModelAndView("redirect:/users");
	}
	
	/**
	 * Create new Admin
	 * @param res
	 * @param model
	 * @param user
	 * @param br
	 * @return
	 */
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public ModelAndView createAdmin(HttpServletRequest req, HttpServletResponse res, Model model, @ModelAttribute(value="newAdmin") Admin user, BindingResult br) {
		System.out.println("/admin");
		
		if (!br.hasErrors()) {
			/* Write Admin to DB */
			userDAO.create(user);
		}
		req.getSession().setAttribute("pageContext", "admin");
		return new ModelAndView("redirect:/users");
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public void postUser(HttpServletRequest req, HttpServletResponse res,
			@RequestParam("id") String stringID,
			@RequestParam(value="firstName", required=false) String firstName,
			@RequestParam(value="lastName", required=false) String lastName,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="phone", required=false) String phone,
			@RequestParam(value="city", required=false) String city,
			@RequestParam(value="country", required=false) String country,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="stream", required=false) String stream,
			@RequestParam("security-answer") String securityAnswer,
			@RequestParam(value="visibility", required=false) String visibility,
			@RequestParam("status") String statusString,
			@RequestParam(value="title", required=false) String jobTitle,
			@RequestParam(value="employer", required=false) String employer,
			@RequestParam(value="pdate", required=false) String pDate
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
				"&title=" + jobTitle + 
				"&employer=" + employer + 
				"&pdate=" + pDate
				);
		
		long id = Long.parseLong(stringID);
		
		IUser foundUser = userDAO.findUserById(id);
		if (foundUser != null) {
			System.out.println("Found");
			
			
			
		} else {
			// return error message or page
		}
		
		/* Fields for any type of users */
		if (StringHelpers.isData(username)) userDAO.changeUserName(id, username);
		if (StringHelpers.isData(password)) userDAO.updatePassword(id, password);
		if (StringHelpers.isData(securityAnswer)) userDAO.changeSecurityAnswer(id, securityAnswer);
		if (StringHelpers.isData(statusString)) {
			boolean status = Boolean.parseBoolean(statusString);
			if (status) {
				userDAO.activateUser(id);
			} else {
				userDAO.delete(id);
			}
		}
		
		/* Fields for Regular users */
		if (foundUser instanceof IRUser) {
			if (StringHelpers.isData(firstName)) userDAO.changeFirstName(id, firstName);
			if (StringHelpers.isData(lastName)) userDAO.changeLastName(id, lastName);
			if (StringHelpers.isData(email)) userDAO.changeEmail(id, email);
			if (StringHelpers.isData(phone)) userDAO.updatePhoneNumber(id, phone);
			if (StringHelpers.isData(city)) userDAO.changeCity(id, city);
			if (StringHelpers.isData(country)) userDAO.changeCountry(id, country);
			if (StringHelpers.isData(description)) userDAO.updateDescription(id, description);
			if (StringHelpers.isData(visibility)) userDAO.changeVissibility(id, Boolean.parseBoolean(visibility));
		}
		
		/* Fields for Trainees */
		if (foundUser instanceof Trainee) {
			if (StringHelpers.isData(stream)) userDAO.changeStream(id, stream);
			req.getSession().setAttribute("pageContext", "trainee");
		}
		
		/* Fields for Consultants */
		if (foundUser instanceof Consultant) {
			if (StringHelpers.isData(jobTitle)) userDAO.updateJobTitle(id, jobTitle);
			if (StringHelpers.isData(employer)) userDAO.updateEmployer(id, employer);
			/* TODO: update placement date */
			if (StringHelpers.isData(pDate)) { }
			req.getSession().setAttribute("pageContext", "consultant");
		}
		
		if (foundUser instanceof Admin) {
			req.getSession().setAttribute("pageContext", "admin");
		}
		
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
