 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.sie.charity_network.POJOs.Notification;
import org.sie.charity_network.POJOs.Post;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.services.NotificationService;
import org.sie.charity_network.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author sie
 */
@Controller
public class NotificationController {
    @Autowired
    private Environment environment;
    @Autowired
    private PostService postService;
    @Autowired
    private NotificationService notificationService;
    
    @GetMapping("/{userId}/notification/")
    public String renderUserNotificationList(@PathVariable String userId, Model model, HttpSession httpSession){
        List<Notification> notificationList = notificationService.getNotificationList(Integer.parseInt(userId), false);
        notificationService.readAllNotifications(notificationList);
        User currentUser = (User) httpSession.getAttribute("currentUser");
        currentUser.setUnreadNotiAmount(notificationService.getUnreadNotificationsAmount(currentUser.getId()));
        httpSession.setAttribute("currentUser", currentUser);
        model.addAttribute("notificationList", notificationList);
        return "userNotificationList";
    }
}
