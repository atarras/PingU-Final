package com.fdmgroup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;

@Controller
public class UserController {
	UserDAO userDAO = new UserDAO();

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
	public String getUserById(@RequestParam("userID") Long userID) {
		IUser foundUser = userDAO.findUserById(userID);
		if (foundUser == null) {
			/* TODO: add nothing found message NO USER FOUND */
			return null; // add the correct view string
		}

		/* TODO: add success message and add the user to request attribute */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String getAllUsers() {
		List<IUser> allUsers = userDAO.getAllUsers();

		if (allUsers == null || allUsers.size() < 1) {
			/* TODO: add nothing found message NO USERS FOUND */
			return null; // add the correct view string
		}

		/* TODO: add success message and list of users to request attribute */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String getRgularUsers() {
		List<IUser> allUsers = userDAO.getAllRegularUsers();

		if (allUsers == null || allUsers.size() < 1) {
			/* TODO: add nothing found message NO USERS FOUND */
			return null; // add the correct view string
		}

		/* TODO: add success message and list of users to request attribute */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String getUSerByType(@RequestParam("type") String type) {
		List<IUser> allUsers = userDAO.getUserByType(type);

		if (allUsers == null || allUsers.size() < 1) {
			/* TODO: add nothing found message NO USERS FOUND */
			return null; // add the correct view string
		}

		/* TODO: add success message and list of users to request attribute */
		return null; // add the correct view string
	}

	public String changeVissibility(@RequestParam("userID") Long userID,
			@RequestParam("vissibility") Boolean vissibility) {

		IRUser user = userDAO.changeVissibility(userID, vissibility);

		if (user.isVisibility() != vissibility) {
			/* TODO: add error message Vissibility not changed */
			return null; // add the correct view string
		}

		/* TODO: add success message VISSIBILITY CHANGED */
		return null; // add the correct view string

	}

	public String changeContact(@RequestParam("userID") Long userID, @RequestParam("newContact") String contact) {

		IRUser user = userDAO.updatePhoneNumber(userID, contact);

		if (!user.getPhoneNumber().equals(contact)) {
			/* TODO: add error message PHONE NUMBER NOT CHANGED */
			return null; // add the correct view string
		}

		/* TODO: add success message PHONE NUMBER CHANGED */
		return null; // add the correct view string

	}
	
	public String changePassword(HttpServletRequest req ,@RequestParam("userID") Long userID, @RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword) {
		HttpSession session = req.getSession();
		IUser user = (IUser)session.getAttribute("newUser");
//		if()
		
		return null;

	}
}
