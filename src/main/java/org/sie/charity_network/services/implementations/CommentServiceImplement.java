/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import org.springframework.stereotype.Service;
import org.sie.charity_network.services.CommentService;
import org.sie.charity_network.repositories.CommentRepository;
import java.util.Date;
import org.sie.charity_network.POJOs.Comment;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sie
 */
@Service
public class CommentServiceImplement implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void addComment(Comment comment) {
        comment.setCreatedDate(new Date());
        commentRepository.addComment(comment);
    }
    
    
}
