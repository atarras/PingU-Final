package com.fdmgroup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.GroupDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Admin;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.Group;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Trainee;

//TODO: Add proper RequestMappings for controller methods and return proper JSP files. Figure how 
// information is being passed to controller to update REquest param with front end.


/**
 * 
 *	GroupController handles any logic revolving the Group model.
 *	Includes creating a group, adding users to a group, and showing all users in a group.
 *
 */
@Controller
public class GroupController {
	/**
	 * Data Access Object to interact with the Group table.
	 */
	@Autowired
	private GroupDAO groupDao ;
	/**
	 * Data Access Object to interact with the User table.
	 */
	@Autowired
	private UserDAO userDao;
	
	
	/* ADMIN FUNCTIONALITY */
	
	/**
	 * 
	 * Redirect to the create group form adding the Group object.
	 * @param model: To add the group attribute to be linked to the form to be sent.
	 * @return The name of the .jsp file to redirect to.
	 */
	//@RequestMapping("/")
	public String goToCreateGroupPage(Model model){
		model.addAttribute("newGroup", new Group());
		//TODO: Returns the .jsp file that has the form to create the group.
		return null;
	}
	
	/**
	 * 
	 * User calls method to persist group.
	 * 
	 * @param g: The group user wants to persist.
	 */
	//@RequestMapping("/testSubmit")
	public String createGroup(@ModelAttribute(value="newGroup") Group group){
		groupDao.create(group);
		return null;
	}
	
	/**
	 * Adds the user to the list of group members in specified group.
	 * 
	 * @param userID: ID of user to be added 
	 * @param groupID: ID of group user will be added to
	 * @return the .jsp file to be redirected to
	 */
	//@RequestMapping("/addUserToGroup")
	public String addUserToGroup(@RequestParam("userID") Long userID, @RequestParam("groupID") Long groupID){
		Group currGroup = groupDao.findByGroupId(groupID);
		IUser user = userDao.findUserById(userID); 
		userDao.updateGroup(user.getUserId(), currGroup);
		groupDao.addGroupMember(currGroup, user);		
		//TODO Return proper jsp file
		return null;
	}
	
	/**
	 * Activate the group specified
	 * @param groupID: ID of the group to activate
	 * @return the .jsp file to be redirected to
	 */
	//@RequestMapping("/activate")
	public String activateGroup(@RequestParam("groupID") Long groupID){
		Group currGroup = groupDao.findByGroupId(groupID);
		currGroup.setActive(true);
		groupDao.update(currGroup);
		System.out.println(currGroup);
		//TODO Return proper jsp file
		return null;
	}

	/**
	 * Deactivate the group. Set the group field for all users in group members list to null.
	 * @param request
	 * @return the .jsp file to be redirected to
	 */
	//@RequestMapping("/deactivate")
	public String deactivateGroup(@RequestParam("groupID") Long groupID){
		Group currGroup = groupDao.findByGroupId(groupID);
//		List<IUser> currMembers = currGroup.getGroupMembers();
//		for (IUser currUser : currMembers) {
//			userDao.removeFromGroup(currUser.getUserId());
//		}
		currGroup.setActive(false);
		groupDao.update(currGroup);
		System.out.println(currGroup);
		//TODO Return proper jsp file
		return null;
	}
	
	/* USER Functionality */
	
	
	/**
	 * 
	 * Retrieve the list of members for the specified group.
	 * 
	 * @param g: The group user wants to retrieve the list of members for.
	 * @return List of users currently in the group.
	 */
	// @RequestMapping("")
	public void goToGroupPage(HttpServletRequest request){
		HttpSession session = request.getSession();
		IUser currUser = (IUser) session.getAttribute("currUser");
		if(currUser instanceof Trainee){
			Trainee currTrainee = (Trainee) currUser;
			// TODO Send to Trainee group with list of current members of group
		} else if (currUser instanceof Consultant){
			Consultant currConsultant = (Consultant) currUser;
			// TODO Send to Consultant's Company Group with list of current members of group
		} else {
			Admin currAdmin = (Admin) currUser;
			// TODO Send to group managing page
		}
	}

	
}
