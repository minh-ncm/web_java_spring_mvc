/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import org.sie.charity_network.POJOs.Tag;
import org.sie.charity_network.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sie
 */
@Controller
public class TagController {
    @Autowired
    private TagService tagService;
    
    @GetMapping("/tag/create/")
    public String renderTagCreatePage(Model model){
        model.addAttribute("tag", new Tag());
        return "tagCreation";
    }
    
    @PostMapping("tag/create/")
    public String submitTag(@ModelAttribute Tag tag, Model model){
        if (!tagService.addTag(tag))
            model.addAttribute("error", "Cannot create tag. Try again");
        model.addAttribute("isCreated", true);
        model.addAttribute("tag", new Tag());
        return "tagCreation";
    }
}
