package com.fdmgroup.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.fdmgroup.model.Admin;
import com.fdmgroup.model.IUser;

@WebListener
public class UserCounterListener implements HttpSessionAttributeListener {

	static private Map<Long, IUser> users = new HashMap<>();

	public void attributeAdded(HttpSessionBindingEvent e) {

		IUser newLoggedInUser = (IUser) e.getValue();
		if(newLoggedInUser instanceof Admin)
			return;
		if (e.getName().equals("newUser")) {
			users.put(newLoggedInUser.getUserId(), newLoggedInUser);
			System.out.println("USER HAS BEEN ADDED TO users");
			e.getSession().getServletContext().setAttribute("loggedInUsers", users);
			return;
		}

	}

	public void attributeRemoved(HttpSessionBindingEvent e) {
		IUser loggedOutUser = (IUser) e.getValue();
		if(loggedOutUser instanceof Admin)
			return;
		if (e.getName().equals("newUser")) {
			users.remove(loggedOutUser.getUserId());
			System.out.println("USER HAS BEEN REMOVED TO users");
			e.getSession().getServletContext().setAttribute("loggedInUsers", users);
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
	}
}
