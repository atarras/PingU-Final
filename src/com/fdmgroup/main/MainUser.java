package com.fdmgroup.main;

import com.fdmgroup.DAO.IUserDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Trainee;

public class MainUser {
	
	public static void main(String[] args) {
//		Trainee trainee = new Trainee();
//		trainee.setCity("city");
//		trainee.setCountry("country");
//		trainee.setEmail("email1");
//		trainee.setFirstName("firstname");
//		trainee.setLastName("lastname");
//		trainee.setLinkedInUrl("linkedin");
//		trainee.setPassword("password");
//		trainee.setPhoneNumber("1234567891");
//		trainee.setStatus(true);
//		trainee.setStream("Java");
//		trainee.setUsername("username2");
//		trainee.setVisibility(true);
//		trainee.setSecurityAnswer("answer1");
//		
		IUserDAO userDAO = new UserDAO();
		
//		Admin admin = new Admin();
//		admin.setPassword("admin");
//		admin.setStatus(true);
//		admin.setUsername("admin");
//		
//		userDAO.create(trainee);
//		userDAO.create(admin);
//		IUser user = new Trainee();
//		user.setUserId(100002);
//		userDAO.delete(user);
//		userDAO.changeVissibility(100001L, false);
//		userDAO.updatePhoneNumber(100001L, "9999999999");
//		userDAO.updatePassword(100001L, "rajat");
//		IUser loginUser = userDAO.loginUser("username1", "rajat");
//		if(loginUser instanceof Trainee){
//			System.out.println(loginUser);
//			Trainee train = (Trainee)loginUser;
//			System.out.println(train);
//		}
//		
//		userDAO.updateEmployer(100000L, "RBC");
//		userDAO.updateJobTitle(100000L, "Sesior Software Developer");
//		userDAO.updateDescription(100000L, "Bara pa pa pa.. I'm Lovin' it!!");
//		System.out.println(loginUser.getUserId());
		//		Consultant consultant = new Consultant();
//		consultant.setCity("city");
//		consultant.setCountry("country");
//		consultant.setCurrentTitle("Software Developer");
//		consultant.setEmail("email");
//		consultant.setEmployer("TD Bank");
//		consultant.setFirstName("firstname");
//		consultant.setLastName("lastname");
//		consultant.setLinkedInUrl("linked");
//		consultant.setPassword("paswword");
//		consultant.setpDate(new Date(System.currentTimeMillis()));
//		consultant.setPhoneNumber("1213645749");
//		consultant.setUsername("username");
//		userDAO.create(consultant);
//		userDAO.activateUser(100000L);
		String recoverPassword = userDAO.recoverPassword("username2", "answer1");
		System.out.println(recoverPassword);
		
	}

}
