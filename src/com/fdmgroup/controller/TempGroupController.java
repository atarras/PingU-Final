package com.fdmgroup.controller;

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

import com.fdmgroup.DAO.GroupDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Group;

@Controller
public class TempGroupController {
	/**
	 * Data Access Object to interact with the Group table.
	 */
	@Autowired
	private GroupDAO groupDao ;
	/**
	 * Data Access Object to interact with the User table.
	 */
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * Sends us to a page that lists all groups (Admin view).
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/groups", method=RequestMethod.GET)
	public String getGroupsPage(HttpServletRequest req, Model model) {
		System.out.println("/groups/GET");
		
		/* Prepare model with a Group so we can create one if needed */
		model.addAttribute("newGroup", new Group());
		
		return "groups";
	}
	
	/**
	 * Create a new Group (via Admin view).
	 * @param req
	 * @param res
	 * @param model
	 * @param group
	 * @param br
	 * @return
	 */
	@RequestMapping(value="/group", method=RequestMethod.POST)
	public void createGroup(HttpServletRequest req, HttpServletResponse res, Model model, @ModelAttribute(value="newGroup") Group group, BindingResult br) {
		System.out.println("/group/POST");
		
		System.out.println(group);
		if (!br.hasErrors()) groupDao.create(group);
		
		//return new ModelAndView("redirect:/groups");
	}

}
