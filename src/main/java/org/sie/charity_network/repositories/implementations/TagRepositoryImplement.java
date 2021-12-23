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
import org.sie.charity_network.POJOs.Tag;
import org.sie.charity_network.repositories.TagRepository;
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
public class TagRepositoryImplement implements TagRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public boolean addTag(Tag tag) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(tag);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Tag> getTagList() {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tag> criteriaQuery = builder.createQuery(Tag.class);
        Root<Tag> tagRoot = criteriaQuery.from(Tag.class);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    
}
