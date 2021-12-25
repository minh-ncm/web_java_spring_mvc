/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.sie.charity_network.repositories;

import java.util.List;
import org.sie.charity_network.POJOs.Notification;
import org.sie.charity_network.POJOs.Post;

/**
 *
 * @author sie
 */
public interface NotificationRepository {
    void addNotification(Notification notification);
    List<Notification> getNotificationList(List<Post> postList, boolean isGetUnread);
    boolean readAllNotifications(List<Notification> notificationList);
    Long getUnreadNotificationsAmount(List<Post> postList);
}
