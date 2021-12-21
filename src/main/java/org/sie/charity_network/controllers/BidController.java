/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.util.Map;
import javax.validation.Valid;
import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Like;
import org.sie.charity_network.POJOs.Notification;
import org.sie.charity_network.services.BidService;
import org.sie.charity_network.services.NotificationService;
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
public class BidController {
    @Autowired
    private Environment environment;
    @Autowired
    private BidService bidService;
    @Autowired
    private NotificationService notificationService;
    
    @PostMapping("/bid/create/")
    public String create(@ModelAttribute("bid")Bid bid){
        bidService.addBid(bid);
        notificationService.addNotification(bid);
        return "redirect:"+environment.getProperty("url.dashboard");
    }
    
    @GetMapping("/post/{postId}/bid/")
    public String renderPostBidList(@PathVariable String postId, Model model) {
        model.addAttribute("bidList", bidService.getBidList(Integer.parseInt(postId)));
        return "postBidList";
    }
}
