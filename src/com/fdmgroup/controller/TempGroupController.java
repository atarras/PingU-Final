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
import com.fdmgroup.enums.Employer;
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
		
		/* Retrieve all groups in our db to be displayed in a table */
		model.addAttribute("groups", groupDao.getAllGroupsAdmin());
		
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
	public ModelAndView createGroup(HttpServletRequest req, HttpServletResponse res, Model model, @ModelAttribute(value="newGroup") Group group, BindingResult br) {
		System.out.println("/group/POST");
		
		System.out.println(group);
		if (!br.hasErrors()) {
			
			/* Check that groupName and groupCategory are set and their combo does not exist in db */
			if (groupDao.getGroupsWithNameAndCategory(group.getGroupName(), group.getGroupCategory()) == null) {
				groupDao.create(group);
			} else {
				System.out.println("Group already exists.");
			}
			
		}
		
		return new ModelAndView("redirect:/groups");
	}

}