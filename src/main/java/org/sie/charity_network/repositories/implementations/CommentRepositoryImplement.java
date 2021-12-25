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
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.sie.charity_network.repositories.CommentRepository;
import org.sie.charity_network.POJOs.Comment;
import org.sie.charity_network.POJOs.Post;
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

    @Override
    public Long getCommentAmount(int postId) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<Comment> commentRoot = criteriaQuery.from(Comment.class);
        criteriaQuery.where(builder.equal(commentRoot.get("post"), postId));
        criteriaQuery.select(builder.count(commentRoot.get("id")));
        Query query = session.createQuery(criteriaQuery);
        return (Long) query.getSingleResult();
    }

    @Override
    public List<Comment> getCommentList(Post post) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> criteriaQuery = builder.createQuery(Comment.class);
        Root<Comment> commentRoot = criteriaQuery.from(Comment.class);
        criteriaQuery.where(builder.equal(commentRoot.get("post"), post.getId()));
        criteriaQuery.orderBy(builder.desc(commentRoot.get("createdDate")));
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    
}
