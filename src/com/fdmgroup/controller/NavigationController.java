package com.fdmgroup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.DAO.GroupDAO;
import com.fdmgroup.DAO.MessagesDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Group;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Messages;

@Controller
public class NavigationController
{
	
	/*Currently these are simple redirect methods to all pages*/
	@Autowired
	UserDAO userDao;
	
	@Autowired
	GroupDAO groupDao;
	
	@Autowired
	private MessagesDAO messagesDao;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String showSearch() {
		return "search";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String showProfile() {
		return "profile";
	}	
	
	@RequestMapping(value="/group", method=RequestMethod.GET)
	public String showGroup(HttpServletRequest req) {
		HttpSession session = req.getSession();
		IUser currUser = (IUser) session.getAttribute("newUser");
		IUser newUser = userDao.findUserById(currUser.getUserId());
		session.setAttribute("newUser", newUser);
		if(newUser.getGroup() != null){
			Group group = (Group) groupDao.findByGroupId(newUser.getGroup().getGroupId());
			List<IUser> listOfMembers = userDao.findAllUsersWithSameGroupId(newUser.getGroup().getGroupId());
			req.setAttribute("groupPage", group);
			req.setAttribute("listOfMembers", listOfMembers);
		}
		return "group";
	}	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String showHome(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		IUser loginUser = (IUser) session.getAttribute("newUser");
		
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
	
	//this will be handled by logincontroller, remove later, here for testing purposes
	@RequestMapping(value="/logouttest", method=RequestMethod.GET)
	public String showLogout(Model model) {
		model.addAttribute("newUser", new IRUser());
		return "login";
	}	
}
