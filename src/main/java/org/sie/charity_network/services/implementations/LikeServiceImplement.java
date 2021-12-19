/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.sie.charity_network.POJOs.Like;
import org.sie.charity_network.POJOs.Post;
import org.sie.charity_network.POJOs.User;
import org.springframework.stereotype.Service;
import org.sie.charity_network.services.LikeService;
import org.sie.charity_network.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sie
 */
@Service
public class LikeServiceImplement implements LikeService{
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public void addLike(Post post, User user) {
        Like like = new Like();
        like.setCreatedDate(new Date());
        like.setUser(user);
        like.setPost(post);
        likeRepository.addLike(like);
    }

    @Override
    public void addLike(Like like) {
        like.setCreatedDate(new Date());
        likeRepository.addLike(like);
    }

    
}
