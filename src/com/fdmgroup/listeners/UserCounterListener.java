package com.fdmgroup.listeners;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.fdmgroup.model.IUser;

@WebListener
public class UserCounterListener implements HttpSessionAttributeListener {

//	private Vector<IUser> users = new Vector<>();
//	private Vector<IUser> newUsers = new Vector<>();
	
	static private  Map<Long,IUser> users = new HashMap<>();
	
//	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	public void attributeAdded(HttpSessionBindingEvent e) {
		
//		if (principal instanceof IUser) {
//			  String username = ((IUser)principal).getUsername();
//			} else {
//			  String username = principal.toString();
//			}
		
		IUser newLoggedInUser = (IUser) e.getValue();
		if (e.getName().equals("newUser")) {
//			if(loggedUsers.size()<1){
			users.put(newLoggedInUser.getUserId(), newLoggedInUser);
//				users.add((IUser) e.getValue());
				System.out.println("USER HAS BEEN ADDED TO users");
				e.getSession().getServletContext().setAttribute("loggedInUsers", users);
				return;
//			}
//			Iterator it = loggedUsers.entrySet().iterator();
//		    while (it.hasNext()) {
//		        Map.Entry pair = (Map.Entry)it.next();
//		        System.out.println(pair.getKey() + " = " + pair.getValue());
//		        it.remove(); // avoids a ConcurrentModificationException
//		    }
//			}
//			Collections.sort(users);
		}

		// if (e.getName().equals("newUser") && !users.contains(e.getValue())){
		// users.add((IUser)e.getValue());
		// System.out.println("USER HAS BEEN ADDED TO users");
		// e.getSession().getServletContext().setAttribute("loggedInUsers",
		// users);
		// }
	}

	public void attributeRemoved(HttpSessionBindingEvent e) {
		IUser loggedOutUser = (IUser) e.getValue();
		if (e.getName().equals("newUser")) {
//			for (IUser iUser : users) {
//				if (loggedOutUser.getUserId()!=iUser.getUserId())
//					newUsers.add(iUser);
//			}
			// users.remove((IUser)e.getValue());
//			users = newUsers;
//			Collections.sort(users);
			users.remove(loggedOutUser.getUserId());
			System.out.println("USER HAS BEEN REMOVED TO users");
			e.getSession().getServletContext().setAttribute("loggedInUsers", users);
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}
}
