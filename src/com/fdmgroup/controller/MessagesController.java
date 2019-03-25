package com.fdmgroup.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.MessagesDAO;
import com.fdmgroup.model.Messages;

@Controller
public class MessagesController {

	@Autowired
	private MessagesDAO messagesDao;

	HttpSession session = null;

	// @RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public String getAllMessages(HttpServletRequest req) {
		List<Messages> allMessages = messagesDao.getAllMessages();
		session = req.getSession();
		if (allMessages == null || allMessages.size() < 1) {
			/* TODO: add nothing found message NO MESSAGES FOUND */
			return null; // add the correct view string
		}

		session.setAttribute("allMessages", allMessages);
		/*
		 * TODO: add success message and list of messages to request attribute
		 */
		return null; // add the correct view string
	}

	public String getMessageById(HttpServletRequest req, @RequestParam("msgId") Long msgId) {
		session = req.getSession();
		Messages foundMsg = messagesDao.findById(msgId);
		if (foundMsg == null) {
			/* TODO: add nothing found message NO MESSAGE FOUND */
			return null; // add the correct view string
		}
		session.setAttribute("message", foundMsg);
		/* TODO: add success message and add the user to request attribute */
		return null; // add the correct view string
	}

	public String getSentMessages(HttpServletRequest req, @RequestParam("userId") Long senderId) {
		session = req.getSession();
		List<Messages> sentMsg = messagesDao.getSentMessagesForUser(senderId);
		if (sentMsg == null || sentMsg.size() < 1) {
			/* TODO: add nothing found message NO MESSAGE FOUND */
			return null; // add the correct view string
		}
		session.setAttribute("sentMsg", sentMsg);
		/*
		 * TODO: add success message and add the messages to request attribute
		 */
		return null; // add the correct view string
	}

	public String getRecievedMessages(HttpServletRequest req, @RequestParam("userId") Long receiverId) {
		session = req.getSession();
		List<Messages> receivedMsg = messagesDao.getReceiverMessagesForUser(receiverId);
		if (receivedMsg == null || receivedMsg.size() < 1) {
			/* TODO: add nothing found message NO MESSAGE FOUND */
			return null; // add the correct view string
		}
		session.setAttribute("receivedMsg", receivedMsg);
		/*
		 * TODO: add success message and add the messages to request attribute
		 */
		return null; // add the correct view string
	}
	
	public String sendMessageToUser(HttpServletRequest req, @ModelAttribute(value="message") Messages message, BindingResult br) {
		session = req.getSession();
		if (!br.hasErrors()){
			message.setSentTime(new Date(System.currentTimeMillis()));
			Messages sentMessage = messagesDao.sendMessage(message);
		}
		/*
		 * TODO: add success message and add the messages to request attribute
		 */
		return null; // add the correct view string
	}
}
