/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.sie.charity_network.POJOs.Message;
import org.sie.charity_network.POJOs.OutputMessaage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 *
 * @author sie
 */
@Controller
public class MessageController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessaage send(Message message) throws Exception{
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessaage(message.getFrom(), message.getText(), time);
    }
}
