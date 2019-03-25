package com.fdmgroup.config;

import java.util.List;



import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.*;



@Configuration
@EnableWebSocketMessageBroker

public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer  {

   

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }

    
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
   
    	registry.addEndpoint("/chat").withSockJS();
    	
        
    }
	
}