/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.repositories.implementations;

import org.hibernate.Session;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sie
 */
@Repository
@Transactional
public class UserRepositoryImplement implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public void addUser(User user) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.save(user);
    }
    
}