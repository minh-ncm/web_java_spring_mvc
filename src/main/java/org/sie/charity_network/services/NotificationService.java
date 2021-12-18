/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.sie.charity_network.services;

import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Like;
import org.sie.charity_network.POJOs.Notification;

/**
 *
 * @author sie
 */
public interface NotificationService {
    void addNotification(Comment comment);
    void addNotification(Like like);
    void addNotification(Bid bid);
}
