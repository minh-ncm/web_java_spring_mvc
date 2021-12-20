/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Cloudinary cloudinary;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        post.setCreatedDate(new Date());
        try {
            Map uploadResult = cloudinary.uploader().upload(
                    post.getImageFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto")
            );
            post.setImageUrl((String) uploadResult.get("url"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        postRepository.addPost(post);
    }    

    @Override
    public List<Post> getPost(int page, int maxResult) {
        return postRepository.getPost(page, maxResult);
    }

    @Override
    public Post getPost(int id) {
        return postRepository.getPost(id);
    }
    
    @Override
    public Long getPostAmount() {
        return postRepository.getPostAmount();
    }

    @Override
    public List<Object[]> getPostStatistic(Date afterDate, Date beforeDate) {
        return postRepository.getPostStatistic(afterDate, beforeDate);
    }

    @Override
    public boolean updatePost(int postId, Post updatedPost) {
        Post post = postRepository.getPost(postId);
        return postRepository.updatePost(post, updatedPost);
    }

    @Override
    public boolean deletePost(int postId) {
        Post post = postRepository.getPost(postId);
        String parts[] = post.getImageUrl().split("/");
        String imageId = parts[parts.length-1].split("\\.")[0];
        try {
            cloudinary.uploader().destroy(
                    imageId,
                    ObjectUtils.asMap("resource_type", "image"));
        } catch (IOException ex) {
            Logger.getLogger(PostServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
        return postRepository.deletePost(post);
    }
    
    
}
