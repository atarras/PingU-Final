package com.fdmgroup.DAO;

import java.util.List;

import com.fdmgroup.model.Group;
import com.fdmgroup.model.IUser;

public interface IUserDAO {
	
	IUser create(IUser user);
	void delete(IUser user);
	IUser activateUser(Long userId);
	IUser findUserById(Long userId);
	List<IUser> getAllUsers();
	List<IUser> getAllRegularUsers();
	List<IUser> getUserByType(String type);
	void changeVissibility(Long userId, Boolean newVissibility);
	void updatePhoneNumber(Long userId, String newPhone);
	void updatePassword(Long userId, String newPassword);
	IUser loginUser(String username, String password);
	void updateGroup(Long userId, Group group);
	void updateEmployer(Long userId, String newEmployer);
	void updateJobTitle(Long userId, String newTitle);
	void updateDescription(Long userId, String newDesc);

}
