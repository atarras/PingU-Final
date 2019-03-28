package com.fdmgroup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.OneToOne;
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
import org.springframework.web.context.support.HttpRequestHandlerServlet;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;


@Controller
@ComponentScan(basePackages = {"com.fdmgroup.config"})
public class ChatController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	

	@RequestMapping("/chat")
	public String showChat(HttpServletRequest req){
	
		
		return "chat";
	}
	
	@RequestMapping("/SingleUserChat")
	public String SingleUserChat(@RequestParam (value="userName")String userName ,HttpServletRequest req){
		req.setAttribute("userName",userName );
		
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
		

    	
    	String content = (message.getName()+": "+msg.getContent().toString()+"                                                 " +"("+new SimpleDateFormat("HH:mm").format(new Date()).toString()+")" );
    	
    	OneToOneMessage messages = new OneToOneMessage(content);
    	
    	
		messagingTemplate.convertAndSendToUser(message.getToUser(), "/queue/reply", messages);
	}
	
	
	

	
	
}