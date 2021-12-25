/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.sie.charity_network.POJOs.Message;
import org.sie.charity_network.POJOs.OutputMessaage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author sie
 */
@Controller
public class MessageController {
    @Autowired
    private SimpMessagingTemplate template;
    
    @MessageMapping("/secured/room")
    public void sendSpedìic(
            @Payload Message msg, 
            Principal user,
            @Header("simpSessonId") String sessionId) {
        OutputMessaage out = new OutputMessaage(
                msg.getFrom(), 
                msg.getText(), 
                new SimpleDateFormat("HH:mm").format(new Date())
        );
        template.convertAndSendToUser(msg.getTo(), "/secured/user/queue/specific-user", out);
    }
    
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessaage send(Message message) throws Exception{
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessaage(message.getFrom(), message.getText(), time);
    }
}
