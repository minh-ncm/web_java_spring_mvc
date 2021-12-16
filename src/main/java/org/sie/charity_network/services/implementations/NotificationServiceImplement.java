/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import java.util.Date;
import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Like;
import org.sie.charity_network.POJOs.Notification;
import org.sie.charity_network.services.NotificationService;
import org.sie.charity_network.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sie
 */
@Service
public class NotificationServiceImplement implements NotificationService{
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void addNotification(Notification notification, Comment comment) {
        notification.setCreatedDate(new Date());
        notification.setComment(comment);
        notification.setUser(comment.getUser());
        notification.setPost(comment.getPost());
        notificationRepository.addNotification(notification);
    }
    
    @Override
    public void addNotification(Notification notification, Like like) {
        notification.setCreatedDate(new Date());
        notification.setLike(like);
        notification.setUser(like.getUser());
        notification.setPost(like.getPost());
        notificationRepository.addNotification(notification);
    }
    
    @Override
    public void addNotification(Notification notification, Bid bid) {
        notification.setCreatedDate(new Date());
        notification.setBid(bid);
        notification.setUser(bid.getUser());
        notification.setPost(bid.getPost());
        notificationRepository.addNotification(notification);
    }
    
    
}
