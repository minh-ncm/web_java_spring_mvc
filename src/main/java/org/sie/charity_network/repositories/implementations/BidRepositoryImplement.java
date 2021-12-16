/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.repositories.implementations;

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
    
}
