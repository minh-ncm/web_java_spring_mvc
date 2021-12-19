/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sie.charity_network.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.sie.charity_network.services.LikeService;
import org.sie.charity_network.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sie
 */
@Controller
public class AdminHomeController {
    @Autowired
    private PostService postService;
    
    @GetMapping("/admin/")
    String render(@RequestParam(required = false) Map params, Model model) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        String beforeDateStr = (String) params.get("beforeDate");
        String afterDateStr = (String) params.get("afterDate");
        Date beforeDate = new Date();
        Date afterDate = new Date(0L);
        try {
            afterDate = dateFormatter.parse(afterDateStr);
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        try {
            beforeDate = dateFormatter.parse(beforeDateStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("postStatistic", postService.getPostStatistic(afterDate, beforeDate));
        return "adminHome";
    }
}
