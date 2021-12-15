/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.util.Date;
import javax.validation.Valid;
import org.sie.charity_network.POJOs.Post;
import org.sie.charity_network.services.PostService;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sie
 */
@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/post/create/")
    public String render(Model model) {
        model.addAttribute("post", new Post());
        return "postCreation";
    }
    
    @PostMapping("/post/create/")
    public String submit(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult){
        
        if(bindingResult.hasErrors())
            return "postCreation";
        post.setEndDate(new Date());
        post.setOwner(userService.getUser(1));
        postService.addPost(post);
        return "dashboard";
    }
}
