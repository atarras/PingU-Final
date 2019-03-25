
package com.fdmgroup.DAO;


import java.util.List;

import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.Group;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Trainee;

public interface IUserDAO {
	
	IUser create(IUser user);
	IUser delete(Long userId);
	IUser activateUser(Long userId);
	IUser findUserById(Long userId);
	List<IUser> findByUserName(String username);
	List<IRUser> findByEmail(String email);
	List<IUser> getAllUsers();
	List<IUser> getAllRegularUsers();
	List<IUser> getUserByType(Class type);
	IRUser changeVissibility(Long userId, Boolean newVissibility);
	IRUser updatePhoneNumber(Long userId, String newPhone);
	IUser updatePassword(Long userId, String newPassword);
	IUser loginUser(String username, String password);
	IRUser updateGroup(Long userId, Group group);
	Consultant updateEmployer(Long userId, String newEmployer);
	Consultant updateJobTitle(Long userId, String newTitle);
	IRUser updateDescription(Long userId, String newDesc);
	String recoverPassword(String username, String answer);
	IRUser removeFromGroup(Long userId);
	IRUser changeCity(Long userId, String newCity);
	IRUser changeCountry(Long userId, String newCountry);
	List<IRUser> findUsersByFullName(String fname, String lname);
	IRUser updateToConsultant(Long traineeId, String jobTitle, String employer);
	List<IRUser> findAllUsers();
	IUser changeSecurityAnswer(Long userId, String newAnswer);
	IUser changeUserName(Long userId, String newUsername);
	IRUser changeEmail(Long userId, String newEmail);
	IRUser changeFirstName(Long userId, String newFirstName);
	IRUser changeLastName(Long userId, String newLastName);
	IRUser changeLinkedIn(Long userId, String newLinkedIn);
	Trainee changeStream(Long userId, String newStream);
}

