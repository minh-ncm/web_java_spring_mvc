/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import java.util.Date;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.repositories.UserRepository;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sie
 */
@Service
public class UserServiceImplement implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void addUser(User user) {
        user.setCreatedDate(new Date());
        user.setIsAdmin(false);
        userRepository.addUser(user);
    }
    
}
