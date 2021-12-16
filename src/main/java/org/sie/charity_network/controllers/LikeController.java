/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.util.Map;
import org.sie.charity_network.POJOs.Post;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.services.LikeService;
import org.sie.charity_network.services.PostService;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sie
 */
@Controller
public class LikeController {
    @Autowired
    private LikeService likeService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    
    @GetMapping("like/create/")
    String create(@RequestParam Map<String, String> params, Model model) {
//        int userId = Integer.parseInt((String) params.get("userId"));
        int postId = Integer.parseInt((String) params.get("postId"));
        User user = userService.getUser(1);
        Post post = postService.getPost(postId);
        model.addAttribute("postId", postId);
        likeService.addLike(post, user);
        return "redirect:/";
    }
}
