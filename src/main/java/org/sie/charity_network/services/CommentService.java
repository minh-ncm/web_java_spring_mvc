/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.sie.charity_network.services;

import java.util.List;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Post;

/**
 *
 * @author sie
 */
public interface CommentService {
    void addComment(Comment comment);
    Long getCommentAmount(Post post);
    List getCommentList(Post post);
}
