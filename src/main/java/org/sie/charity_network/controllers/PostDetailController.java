/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import javax.validation.Valid;
import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Like;
import org.sie.charity_network.POJOs.Notification;
import org.sie.charity_network.services.BidService;
import org.sie.charity_network.services.CommentService;
import org.sie.charity_network.services.NotificationService;
import org.sie.charity_network.services.PostService;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sie
 */
@Controller
public class PostDetailController {
    @Autowired
    private Environment environment;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/post/{id}/")
    String renderPostDetail(@PathVariable String id, Model model) {
        model.addAttribute("user", userService.getUser(1)); // remove when have authentication
        model.addAttribute("post", postService.getPost(Integer.parseInt(id)));
        model.addAttribute("comment", new Comment());
        model.addAttribute("bid", new Bid());
        model.addAttribute("like", new Like());
        return "postDetail";
    }
        
}
