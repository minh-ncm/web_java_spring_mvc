/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public void addUser(User user) {
        user.setCreatedDate(new Date());
        user.setIsAdmin(false);
        user.setIsReport(false);
        if(user.getImageFile().isEmpty())
            user.setAvatarUrl("https://res.cloudinary.com/dqrcn7ljx/image/upload/v1639479467/user_dnxjlf.svg");
        else
        {
            try {
                Map uploadResult = cloudinary.uploader().upload(
                        user.getImageFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatarUrl((String) uploadResult.get("url"));
            } catch (IOException ex) {
                System.err.println("upload image failed");
                ex.printStackTrace();
            }
        }
        userRepository.addUser(user);
    }

    @Override
    public User getUser(int id) {
        return userRepository.getUser(id);
    }

}
