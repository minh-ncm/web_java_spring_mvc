/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.repositories.implementations;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.sie.charity_network.POJOs.Report;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.repositories.ReportRepository;
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
public class ReportRepositoryImplement implements ReportRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public boolean addReport(Report report) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(report);   
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    
    
}
