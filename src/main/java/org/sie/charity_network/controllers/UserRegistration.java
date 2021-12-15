/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import javax.validation.Valid;
import org.sie.charity_network.POJOs.User;
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
public class UserRegistration {
    @Autowired
    private UserService userService;
    
    @GetMapping("/account/register/")
    public String render(Model model){
        model.addAttribute("user", new User());
        return "userRegistration";
    }
    
    @PostMapping("/account/register/")
    public String submit(@ModelAttribute("user") @Valid  User user, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "userRegistration";
        userService.addUser(user);
        return "dashboard";
    }
}
