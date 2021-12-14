/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.POJOs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sie
 */
@Entity
@Table(name = "report")
public class Report implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int reason;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private User reporter;
    @ManyToOne
    @JoinColumn(name = "reported_id")
    private User reported;

    public Report() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the reason
     */
    public int getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(int reason) {
        this.reason = reason;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the reporter
     */
    public User getReporter() {
        return reporter;
    }

    /**
     * @param reporter the reporter to set
     */
    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    /**
     * @return the reported
     */
    public User getReported() {
        return reported;
    }

    /**
     * @param reported the reported to set
     */
    public void setReported(User reported) {
        this.reported = reported;
    }
    
}
