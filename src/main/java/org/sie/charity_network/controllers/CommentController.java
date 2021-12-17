/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import javax.validation.Valid;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Notification;
import org.sie.charity_network.services.CommentService;
import org.sie.charity_network.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sie
 */
@Controller
public class CommentController {
    @Autowired
    private Environment environment;
    @Autowired
    private CommentService commentService;
    @Autowired
    private NotificationService notificationService;
    
    @PostMapping("/comment/create/")
    String create(@ModelAttribute("comment")@Valid Comment comment, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "dashboard";
        commentService.addComment(comment);
        notificationService.addNotification(new Notification(), comment);
        return "redirect:"+environment.getProperty("url.dashboard");
    }
}
