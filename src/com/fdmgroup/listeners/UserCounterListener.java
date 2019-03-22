package com.fdmgroup.listeners;

import java.util.Vector;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.fdmgroup.model.IUser;


@WebListener
public class UserCounterListener implements HttpSessionAttributeListener {
      
	private Vector<IUser> users = new Vector<>();
    
    public void attributeAdded(HttpSessionBindingEvent e)  { 
      if (e.getName().equals("newUser") && !users.contains(e.getValue())){
            users.add((IUser)e.getValue());
            System.out.println("USER HAS BEEN ADDED TO users");
            e.getSession().getServletContext().setAttribute("loggedInUsers", users);
      	}
    }

      public void attributeRemoved(HttpSessionBindingEvent e)  { 
            if (e.getName().equals("newUser")){
	            users.remove((IUser)e.getValue());
	            System.out.println("USER HAS BEEN REMOVED TO users");
	            e.getSession().getServletContext().setAttribute("loggedInUsers", users);
            }
      }

      public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
}

