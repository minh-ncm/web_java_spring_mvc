/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.sie.charity_network.services;

import org.sie.charity_network.POJOs.User;

/**
 *
 * @author sie
 */
public interface UserService {
    void addUser(User user);
    User getUser(int id);
}
