/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.sie.charity_network.services.PostService;
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
    
    @GetMapping("/")
    public String render(@RequestParam(required = false) Map<String, String> params, Model model) {
        int maxResult = 10;
        int currentPage = Integer.parseInt(params.getOrDefault("currentPage", "1"));
        double maxPage = Math.ceil(postService.getPostAmount().intValue() / (double)maxResult);
        
        model.addAttribute("postList", postService.getPost(currentPage, maxResult));
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("currentPage", currentPage);
        return "dashboard";
    }
}
