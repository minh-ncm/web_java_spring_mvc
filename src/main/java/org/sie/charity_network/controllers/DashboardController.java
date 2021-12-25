/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Like;
import org.sie.charity_network.POJOs.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.sie.charity_network.services.PostService;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sie
 */
@Controller
public class DashboardController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String render(@RequestParam(required = false) Map<String, String> params, Model model, HttpSession session) {
        int maxResult = 30;
        int currentPage = Integer.parseInt(params.getOrDefault("currentPage", "1"));
        double maxPage = Math.ceil(postService.getPostAmount().intValue() / (double)maxResult);
        
        model.addAttribute("postList", postService.getPost(currentPage, maxResult));
//        model.addAttribute("user", userService.getUser(1)); // remove when have authentication
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("like", new Like());
        model.addAttribute("comment", new Comment());
        model.addAttribute("bid", new Bid());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        return "dashboard";
    }
}
