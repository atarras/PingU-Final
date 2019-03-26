package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Trainee;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	HttpSession session = null;

	// #########################Admin
	// Operations######################################

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
	public String getUserByType(HttpServletRequest req, @RequestParam("type") Class type) {
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

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateUserName(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newUserName") String newUsername) {
		session = req.getSession();
		List<IUser> foundUsers = userDAO.findByUserName(newUsername);
		if (foundUsers.size() >= 1) {
			/* TODO: add error message USER NAME ALREADY EXISTS. */
			return null; // add the correct view string
		}

		IUser user = userDAO.changeUserName(userID, newUsername);
		if (!user.getUsername().equals(newUsername)) {
			/* TODO: add error message USER NAME NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("user", user);
		/* TODO: add success message USER NAME CHANGED */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateStream(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newStream") String newStream) {
		session = req.getSession();
		Trainee user = userDAO.changeStream(userID, newStream);
		if (!user.getStream().equals(newStream)) {
			/* TODO: add error message STREAM NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("user", user);
		/* TODO: add success message STREAM CHANGED */
		return null; // add the correct view string
	}

	// #########################User
	// Operations######################################

	// To find users from search bar using name
	@RequestMapping(value = "/searchUsers", method = RequestMethod.POST)
	public String findUsersByName(HttpServletRequest req, @RequestParam("searchName") String searchName) {
		// System.out.println("Inside UC findUsersByName method");
		List<IRUser> foundUsers = null;
		if (searchName == null || searchName == "") {
			foundUsers = userDAO.findAllUsers();
		} else {
			String searchNames = searchName.toLowerCase();
			System.out.println("String name entered: " + searchNames);
			String NamesWithoutComma = searchNames.replace(",", " ");
			String NamesWithoutSpaces = NamesWithoutComma.replace("\\s+", " ");
			String[] splitNames = NamesWithoutSpaces.split(" ");
			System.out.println("String name after filter: " + NamesWithoutSpaces);
			if (splitNames.length <= 0) {
				System.out.println("Found 0 strings");
				foundUsers = userDAO.findAllUsers();
			} else if (splitNames.length == 1) {
				System.out.println("Found 1 string");
				splitNames[0] = "%" + splitNames[0] + "%";
				foundUsers = userDAO.findUsersByFullName(splitNames[0], "");
			}
			if (splitNames.length >= 2) {
				splitNames[1] = "%" + splitNames[1] + "%";
				System.out.println("Found 2+ strings" + splitNames.length);
				foundUsers = userDAO.findUsersByFullName(splitNames[0], splitNames[1]);
			}

		}

		if (foundUsers != null) {
			session = req.getSession();
			session.setAttribute("foundUsers", foundUsers);

			/*
			 * Hacked out previous search result retained, remove if better new
			 * implementation
			 */
			session.setAttribute("previousSearch", searchName);

			for (IRUser user : foundUsers) {
				System.out.println(user.getUsername());
				System.out.println(user.getFirstName());
				System.out.println(user.getLastName());
				System.out.println(user.getGroup());
			}
		}

		session.setAttribute("errorMsg", "Oops, no user found!");

		return "search";

	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateDescription(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newDesc") String newDesc) {
		session = req.getSession();
		IRUser user = userDAO.updateDescription(userID, newDesc);
		if (!user.getDescription().equals(newDesc)) {
			/* TODO: add error message Description NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message Description CHANGED */
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
			/* TODO: add error message INCORRECT INFORAMTION PROVIDED */
			return null; // add the correct view string
		}

		session.setAttribute("password", password);
		/* TODO: add success message VISSIBILITY CHANGED */
		return null; // add the correct view string

	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String changeToConsultant(HttpServletRequest req, @RequestParam("traineeId") Long traineeId,
			@RequestParam("jobTitle") String jobTitle, @RequestParam("employer") String employer) {

		IRUser updateToConsultant = userDAO.updateToConsultant(traineeId, jobTitle, employer);
		if (updateToConsultant == null) {
			/* TODO: add error message Could not convert */
			return null; // add the correct view string
		}
		/* TODO: add success message Consultant updated */
		return null; // add the correct view string
	}


	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateEmail(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newEmail") String newEmail) {
		session = req.getSession();
		List<IRUser> foundUsers = userDAO.findByEmail(newEmail);
		if (foundUsers.size() >= 1) {
			/* TODO: add error message EMAIL ALREADY EXISTS. */
			return null; // add the correct view string
		}
		IRUser user = userDAO.changeEmail(userID, newEmail);
		if (!user.getEmail().equals(newEmail)) {
			/* TODO: add error message EMAIL NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message EMAIL CHANGED */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateFirstName(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newFirstName") String newFirstName) {
		session = req.getSession();
		IRUser user = userDAO.changeFirstName(userID, newFirstName);
		if (!user.getFirstName().equals(newFirstName)) {
			/* TODO: add error message FIRSTNAME NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message FIRSTNAME CHANGED */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateLastName(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newLastName") String newLastName) {
		session = req.getSession();
		IRUser user = userDAO.changeLastName(userID, newLastName);
		if (!user.getLastName().equals(newLastName)) {
			/* TODO: add error message LAST NAME NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message LAST NAME CHANGED */
		return null; // add the correct view string
	}

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String updateLinkedIn(HttpServletRequest req, @RequestParam("userID") Long userID,
			@RequestParam("newLinkedIn") String newLinkedIn) {
		session = req.getSession();
		IRUser user = userDAO.changeLinkedIn(userID, newLinkedIn);
		if (!user.getLinkedInUrl().equals(newLinkedIn)) {
			/* TODO: add error message LINKEDIN NOT CHANGED */
			return null; // add the correct view string
		}
		session.setAttribute("newUser", user);
		/* TODO: add success message LINKEDIN CHANGED */
		return null; // add the correct view string
	}

}
