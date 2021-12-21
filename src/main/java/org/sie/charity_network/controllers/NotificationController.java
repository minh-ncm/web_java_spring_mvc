/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import org.sie.charity_network.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author sie
 */
@Controller
public class NotificationController {
    @Autowired
    private Environment environment;
    @Autowired
    private NotificationService notificationService;
    
    @GetMapping("/{userId}/notification/")
    public String renderUserNotificationList(@PathVariable String userId, Model model){
        model.addAttribute("notificationList", notificationService.getNotificationList(Integer.parseInt(userId)));
        return "userNotificationList";
    }
}
