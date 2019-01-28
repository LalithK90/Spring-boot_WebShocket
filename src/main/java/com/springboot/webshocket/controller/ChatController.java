package com.springboot.webshocket.controller;

import com.springboot.webshocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/register")
    @SendTo("/sample/public")
    public Message register(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("user", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/send")
    @SendTo("/sample/public")
    public Message sendMessage(@Payload Message chatMessage){
        return chatMessage;
    }
}
