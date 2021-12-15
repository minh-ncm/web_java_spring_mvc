/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.sie.charity_network.services;

import java.util.List;
import org.sie.charity_network.POJOs.Post;

/**
 *
 * @author sie
 */
public interface PostService {
    void addPost(Post post);
    List<Post> getPost(int page, int maxResult);
    Long getPostAmount();
}
