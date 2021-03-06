/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import javax.servlet.http.HttpSession;
import org.sie.charity_network.POJOs.Like;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.services.LikeService;
import org.sie.charity_network.services.NotificationService;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sie
 */
@Controller
public class LikeController {
    @Autowired
    private Environment environment;
    @Autowired
    private LikeService likeService;
    @Autowired
    private NotificationService notificationService;
    
    @PostMapping("like/create/")
    String create(@ModelAttribute("like") Like like, Model model) {
        likeService.addLike(like);
        notificationService.addNotification(like);
        return "redirect:"+environment.getProperty("url.dashboard");
    }
}
