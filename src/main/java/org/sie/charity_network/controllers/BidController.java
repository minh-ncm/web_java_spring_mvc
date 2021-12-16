/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.POJOs.Notification;
import org.sie.charity_network.services.BidService;
import org.sie.charity_network.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sie
 */
@Controller
public class BidController {
    @Autowired
    private Environment environment;
    @Autowired
    private BidService bidService;
    @Autowired
    private NotificationService notificationService;
    @PostMapping("/bid/create/")
    String create(@ModelAttribute("bid") Bid bid, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "";
        bidService.addBid(bid);
        notificationService.addNotification(new Notification(), bid);
        return "redirect:"+environment.getProperty("url.dashboard");
    }
}
