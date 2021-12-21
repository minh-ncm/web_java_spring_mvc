/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import javax.validation.Valid;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Environment environment;
    
    @GetMapping("/user/register/")
    public String render(Model model){
        model.addAttribute("user", new User());
        return "userRegistration";
    }
    
    @PostMapping("/user/register/")
    public String create(@ModelAttribute("user")User user){
        userService.addUser(user);
        return "redirect:"+environment.getProperty("url.user.login");
    }
    
    @GetMapping("/user/login/")
    public String login() {
        return "userLogin";
    }
}
