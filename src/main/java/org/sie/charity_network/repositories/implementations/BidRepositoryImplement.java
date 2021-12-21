/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.repositories.implementations;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.sie.charity_network.POJOs.Bid;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sie.charity_network.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author sie
 */
@Repository
@Transactional
public class BidRepositoryImplement implements BidRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public void addBid(Bid bid) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.save(bid);
    }

    @Override
    public List<Bid> getBidList(int postId) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bid> criteriaQuery = builder.createQuery(Bid.class);
        Root<Bid> bidRoot = criteriaQuery.from(Bid.class);
        criteriaQuery.where(builder.equal(bidRoot.get("post"), postId));
        List<Order> orderList = new ArrayList<>();
        orderList.add(builder.desc(bidRoot.get("amount")));
        orderList.add(builder.asc(bidRoot.get("createdDate")));
        criteriaQuery.orderBy(orderList);
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    
}
