package com.fdmgroup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.model.ChatMessage;
import com.fdmgroup.model.ChatUser;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.OneToOneMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
@ComponentScan(basePackages = {"com.fdmgroup.config"})
public class ChatController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	

	@RequestMapping("/chat")
	public String showChat(){
		return "chat";
	}
	
	@RequestMapping("/SingleUserChat")
	public String SingleUserChat(){
		return "SingleUserChat";
	}
	
	@MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
	


    
    @MessageMapping("/message")
	public void greeting( ChatUser message ,@Payload  OneToOneMessage msg) throws  Exception {
		
/*		Greeting greeting = new Greeting();
		greeting.setContent("hello");*/
		 msg.setTime(new SimpleDateFormat("HH:mm").format(new Date())); 

		messagingTemplate.convertAndSendToUser(message.getToUser(), "/queue/reply", msg);
	}
	
	
	

	
	
}