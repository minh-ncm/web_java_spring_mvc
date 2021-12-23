/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Like;
import org.sie.charity_network.POJOs.Post;
import org.sie.charity_network.POJOs.Tag;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.services.CommentService;
import org.sie.charity_network.services.PostService;
import org.sie.charity_network.services.TagService;
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
public class PostController {
    @Autowired
    private Environment environment;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TagService tagService;
    
    @GetMapping("/post/create/")
    public String render(Model model) {
        Post post = new Post();
        List<Tag> tagList = tagService.getTagList();
        post.setTagList(tagList);
        model.addAttribute("post", post);
        model.addAttribute("tagList", tagList);
        return "postCreation";
    }
    
    @PostMapping("/post/create/")
    public String submit(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult, HttpSession httpSession){
        
        if(bindingResult.hasErrors())
            return "postCreation";
        post.setEndDate(new Date());
        post.setOwner((User) httpSession.getAttribute("currentUser"));
        postService.addPost(post);
        return String.format("redirect:/post/%d/", post.getId());
    }
    
    @GetMapping("/post/{id}/")
    public String renderPostDetail(@PathVariable String id, Model model) {
        Post post = postService.getPost(Integer.parseInt(id));
        model.addAttribute("post", post);
        model.addAttribute("commentList", commentService.getCommentList(post));
        model.addAttribute("comment", new Comment());
        model.addAttribute("bid", new Bid());
        model.addAttribute("like", new Like());
        return "postDetail";
    }
    
    @GetMapping("/post/{postId}/edit/")
    public String renderEditPage(@PathVariable String postId, Model model) {
        Post post = postService.getPost(Integer.parseInt(postId));
        model.addAttribute("post", post);
        return "postEdit";
    }
    
    @PostMapping("/post/{postId}/edit/")
    public String submitPostEdit(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult, @PathVariable String postId) {
        if (bindingResult.hasErrors()) {
            return "postEdit";
        }
        postService.updatePost(Integer.parseInt(postId), post);
        return String.format("redirect:/post/%s/", postId);
    }
    
    
    @PostMapping("/post/{postId}/delete/")
    public String deletePost(@ModelAttribute("post") Post post, @PathVariable String postId, Model model){
        if (postService.deletePost(Integer.parseInt(postId)))
            return String.format("redirect:%s", environment.getProperty("url.dashboard"));
        model.addAttribute("errors", "Something wrong. Can't delete post.");
        return "postEdit";
    }
}
