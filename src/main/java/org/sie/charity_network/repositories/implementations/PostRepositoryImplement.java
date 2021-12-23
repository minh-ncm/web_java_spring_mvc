/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.repositories.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.sie.charity_network.POJOs.Post;
import org.sie.charity_network.POJOs.Post_;
import org.sie.charity_network.POJOs.Tag;
import org.sie.charity_network.repositories.CommentRepository;
import org.sie.charity_network.repositories.LikeRepository;
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
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private CommentRepository commentRepository;

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
    public Post getPost(int id) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);
        
        criteriaQuery.where(builder.equal(postRoot.get("id").as(Integer.class), id));
        
        Query query = session.createQuery(criteriaQuery);
        return (Post) query.getSingleResult();
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

    @Override
    public List<Object[]> getPostStatistic(Date afterDate, Date beforeDate, List<Tag> tagList) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);
        Predicate p1 = builder.between(postRoot.get("createdDate").as(Date.class), afterDate, beforeDate);
        if (tagList != null) {
            Predicate p2 = postRoot.join(Post_.tagList).in(tagList);
            criteriaQuery.where(builder.and(p1, p2));
        } else {
            criteriaQuery.where(p1);
        }
        Query query = session.createQuery(criteriaQuery);
        Set<Post> postList = new HashSet<>(query.getResultList());

        List<Object[]> result = new ArrayList<>();
        for(Post post : postList) {
            Long likeAmount = likeRepository.getLikeAmount(post);
            Long commentAmount = commentRepository.getCommentAmount(post);
            Object[] objectList = {
                post.getId(),
                post.getCreatedDate(),
                likeAmount,
                commentAmount,
            };
            result.add(objectList);
        }
        return result;
    }

    @Override
    public boolean updatePost(Post post, Post updatedPost) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        post.setTitle(updatedPost.getTitle());
        post.setDescription(updatedPost.getDescription());
        try {
            session.update(post);    
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deletePost(Post post) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        try {
            session.delete(post);   
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
    
}
