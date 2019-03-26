package com.fdmgroup.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Admin")
public class Admin extends IUser {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, boolean status) {
		super(username, password, status);
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String username, String password, boolean status, String answer){
		super(username, password,status);
		setSecurityAnswer(answer);
	}

	@Override
	public String toString() {
		return "Admin [UserId = " + getUserId() + ", Username = " + getUsername() + ", Status=" + isStatus() + ", Group=" + getGroup().getGroupName() + "]";
	}

	public Admin(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	
	
}

