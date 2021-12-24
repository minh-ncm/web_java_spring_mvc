/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.repositories.implementations;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.POJOs.Post;
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
    public boolean addUser(User user) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User getUser(int id) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery  = builder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.where(builder.equal(userRoot.get("id").as(Integer.class), id));
        Query query = session.createQuery(criteriaQuery);
        return (User) query.getSingleResult();
    }

    @Override
    public User getUser(String username) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery  = builder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.where(builder.equal(userRoot.get("username"), username));
        Query query = session.createQuery(criteriaQuery);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getUsersByKeyword(String keyword) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery  = builder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.where(builder.like(userRoot.get("username").as(String.class), String.format("%%%s%%", keyword)));
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public boolean updateUser(User user) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        try {
            session.update(user);   
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
