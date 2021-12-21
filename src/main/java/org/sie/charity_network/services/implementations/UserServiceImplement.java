/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.repositories.UserRepository;
import org.sie.charity_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author sie
 */
@Service("userDetailsService")
public class UserServiceImplement implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public boolean addUser(User user) {
        user.setCreatedDate(new Date());
        user.setIsReport(false);
        user.setUserRole(User.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            Map uploadResult = cloudinary.uploader().upload(
                    user.getImageFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatarUrl((String) uploadResult.get("url"));
        } catch (IOException ex) {
            System.err.println("upload image failed");
            ex.printStackTrace();
            return false;
        }
        return userRepository.addUser(user);
    }

    @Override
    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    @Override
    public User getUser(String username) {
        return userRepository.getUser(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUser(username);
        if (user != null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), auth);
    }

    
}
