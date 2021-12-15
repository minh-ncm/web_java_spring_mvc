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
import org.sie.charity_network.POJOs.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sie.charity_network.repositories.PostRepository;

/**
 *
 * @author sie
 */
@Repository
@Transactional
public class PostRepositoryImplement implements PostRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public void addPost(Post post) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.save(post);
    }

    @Override
    public List<Post> getPost(int page,  int maxResult) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);
        Query query = session.createQuery(criteriaQuery);
        query.setMaxResults(maxResult);
        query.setFirstResult((page-1)*maxResult);
        return query.getResultList();
    }

    @Override
    public Long getPostAmount() {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);
        criteriaQuery.select(builder.count(postRoot));
        Query query = session.createQuery(criteriaQuery);
        return (Long) query.getSingleResult();
    }

    
}
