/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.repositories.implementations;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.sie.charity_network.repositories.CommentRepository;
import org.sie.charity_network.POJOs.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author sie
 */
@Repository
@Transactional
public class CommentRepositoryImplement implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public void addComment(Comment comment) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.save(comment);
    }
    
}
