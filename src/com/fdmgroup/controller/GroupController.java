package com.fdmgroup.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.fdmgroup.DAO.GroupDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Group;
import com.fdmgroup.model.IUser;

//TODO: Add RequestMappings linked to the front end.
//TODO: Change how the functions work based on the front end.
@Controller
public class GroupController {
	private GroupDAO groupdao = new GroupDAO();
	private UserDAO userdao = new UserDAO();

	public GroupController() {
		super();
	}
	
	public void createGroup(Group g){
		groupdao.create(g);
	}
	
	public void addUser(Group currGroup, IUser user){
		userdao.updateGroup(user.getUserId(), currGroup);
		currGroup.addUserToGroup(user);
		groupdao.updateGroupMembers(currGroup);		
	}
	
	public List<IUser> showAllUsers(Group g){
		return g.getGroupMembers();
	}

	
}
