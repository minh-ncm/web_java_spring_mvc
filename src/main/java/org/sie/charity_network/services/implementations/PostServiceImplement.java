/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import java.util.Date;
import java.util.List;
import org.sie.charity_network.POJOs.Post;
import org.springframework.stereotype.Service;
import org.sie.charity_network.services.PostService;
import org.sie.charity_network.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sie
 */
@Service
public class PostServiceImplement implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        post.setCreatedDate(new Date());
        postRepository.addPost(post);
    }    

    @Override
    public List<Post> getPost(int page, int maxResult) {
        return postRepository.getPost(page, maxResult);
    }

    @Override
    public Long getPostAmount() {
        return postRepository.getPostAmount();
    }
    
}
