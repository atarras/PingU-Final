package com.fdmgroup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;

@Controller
public class UserController {
	UserDAO userDAO = new UserDAO();
	HttpSession session = null;
	
	
//	#########################Admin Operations######################################

	// @RequestMapping(value="/deactivateUser", method=RequestMethod.POST)
	public String deactivateUser(@RequestParam("userID") Long userID) {

		IUser deletedUser = userDAO.delete(userID);
		if (deletedUser.isStatus()) {
			/* TODO: add error message USER NOT DEACTIVATED */
			return null; // add the correct view string
		}

		/* TODO: add success message USER DEATIVATED */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String activateUser(@RequestParam("userID") Long userID) {
		IUser activateUser = userDAO.activateUser(userID);
		if (!activateUser.isStatus()) {

			/* TODO: add error message USER COULD NOT BE ACTIVATED */
			return null; // add the correct view string
		}

		/*
		 * TODO: add success message USER ACTIVATED and add the user to request
		 * attribute
		 */
		return null; // add the correct view string

	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String getAllUsers(HttpServletRequest req) {
		List<IUser> allUsers = userDAO.getAllUsers();
		session = req.getSession();
		if (allUsers == null || allUsers.size() < 1) {
			/* TODO: add nothing found message NO USERS FOUND */
			return null; // add the correct view string
		}

		session.setAttribute("users", allUsers);
		/* TODO: add success message and list of users to request attribute */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String getRgularUsers(HttpServletRequest req) {
		List<IUser> allUsers = userDAO.getAllRegularUsers();
		session = req.getSession();
		if (allUsers == null || allUsers.size() < 1) {
			/* TODO: add nothing found message NO USERS FOUND */
			return null; // add the correct view string
		}
		session.setAttribute("users", allUsers);
		/* TODO: add success message and list of users to request attribute */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String getUserByType(HttpServletRequest req, @RequestParam("type") String type) {
		List<IUser> allUsers = userDAO.getUserByType(type);
		session = req.getSession();
		if (allUsers == null || allUsers.size() < 1) {
			/* TODO: add nothing found message NO USERS FOUND */
			return null; // add the correct view string
		}
		session.setAttribute("users", allUsers);
		/* TODO: add success message and list of users to request attribute */
		return null; // add the correct view string
	}
	
	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateCompany(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newCompany") String newCompany) {
		session = req.getSession();
		Consultant user = userDAO.updateEmployer(userID, newCompany);
		if (!user.getEmployer().equals(newCompany)) {
			/* TODO: add error message COMPANY NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("user", user);
		/* TODO: add success message COMPANY CHANGED */
		return null; // add the correct view string
	}
	
	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
		public String updateJob(HttpServletRequest req, @RequestParam("userID") Long userID,
				@RequestParam("newJob") String newJob) {
			session = req.getSession();
			Consultant user = userDAO.updateJobTitle(userID, newJob);
			if (!user.getCurrentTitle().equals(newJob)) {
				/* TODO: add error message JOB TITLE NOT CHANGED */
				return null; // add the correct view string
			}
			session.setAttribute("user", user);
			/* TODO: add success message JOB TITLE CHANGED */
			return null; // add the correct view string
		}

//		#########################User Operations######################################
		
	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String changeContact(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newContact") String contact) {
		session = req.getSession();
		IRUser user = userDAO.updatePhoneNumber(userID, contact);

		if (!user.getPhoneNumber().equals(contact)) {
			/* TODO: add error message PHONE NUMBER NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message PHONE NUMBER CHANGED */
		return null; // add the correct view string

	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String changePassword(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword) {
		session = req.getSession();
		IUser user = (IUser) session.getAttribute("newUser");
		if (!user.getPassword().equals(currentPassword)) {
			/* TODO: add error message Inorrect curret password */
			return null; // add the correct view string
		}

		IUser founduser = userDAO.updatePassword(userID, newPassword);
		if (!founduser.getPassword().equals(newPassword)) {
			/* TODO: add error message PASSWORD NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", founduser);
		/* TODO: add success message PASSWORD CHANGED */
		return null; // add the correct view string

	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateDescription(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newDesc") String newDesc) {
		session = req.getSession();
		Consultant user = userDAO.updateDescription(userID, newDesc);
		if (!user.getDescription().equals(newDesc)) {
			/* TODO: add error message Description NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message Description CHANGED */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateCity(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newCity") String newCity) {
		session = req.getSession();
		IRUser user = userDAO.changeCity(userID, newCity);
		if (!user.getCity().equals(newCity)) {
			/* TODO: add error message CITY NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message CITY CHANGED */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateCountry(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newCountry") String newCountry) {
		session = req.getSession();
		IRUser user = userDAO.changeCountry(userID, newCountry);
		if (!user.getCountry().equals(newCountry)) {
			/* TODO: add error message COUNTRY NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message COUNTRY CHANGED */
		return null; // add the correct view string
	}
	
	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
		public String changeVissibility(HttpServletRequest req, @RequestParam("userID") Long userID,
				@RequestParam("vissibility") Boolean vissibility) {
			session = req.getSession();
			IRUser user = userDAO.changeVissibility(userID, vissibility);

			if (user.isVisibility() != vissibility) {
				/* TODO: add error message Vissibility not changed */
				return null; // add the correct view string
			}

			session.setAttribute("newUser", user);
			/* TODO: add success message VISSIBILITY CHANGED */
			return null; // add the correct view string

		}
	
	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String getUserById(HttpServletRequest req, @RequestParam("userID") Long userID) {
		session = req.getSession();
		IUser foundUser = userDAO.findUserById(userID);
		if (foundUser == null) {
			/* TODO: add nothing found message NO USER FOUND */
			return null; // add the correct view string
		}
		session.setAttribute("user", foundUser);
		/* TODO: add success message and add the user to request attribute */
		return null; // add the correct view string
	}
	
	public String getPassword(HttpServletRequest req, @RequestParam("username") String username,
			@RequestParam("sequrityAnswer") String sequrityAnswer) {
		session = req.getSession();
		String password = userDAO.recoverPassword(username, sequrityAnswer);

		if (password == null) {
			/* TODO: add error message INCORRECT INFORAMTION PROVIDED*/
			return null; // add the correct view string
		}

		session.setAttribute("password", password);
		/* TODO: add success message VISSIBILITY CHANGED */
		return null; // add the correct view string

	}

}
