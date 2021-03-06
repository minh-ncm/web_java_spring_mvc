/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.handlers;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.services.NotificationService;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author sie
 */
@Component
public class LoginSuccesshandler implements AuthenticationSuccessHandler{
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        User user = userService.getUser(a.getName());
        user.setUnreadNotiAmount(notificationService.getUnreadNotificationsAmount(user.getId()));
        request.getSession().setAttribute("currentUser", user);
        response.sendRedirect("/charity_network/");
    }


    
}
