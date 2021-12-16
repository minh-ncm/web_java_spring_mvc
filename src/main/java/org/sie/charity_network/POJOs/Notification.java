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
@Table(name = "notifications")
public class Notification implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "is_read")
    private Boolean isRead;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
    @ManyToOne
    @JoinColumn(name = "like_id")
    private Like like;
    @ManyToOne
    @JoinColumn(name = "bid_id")
    private Bid bid;

    public Notification() {
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
     * @return the isRead
     */
    public Boolean getIsRead() {
        return isRead;
    }

    /**
     * @param isRead the isRead to set
     */
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    /**
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the comment
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }

    /**
     * @return the like
     */
    public Like getLike() {
        return like;
    }

    /**
     * @param like the like to set
     */
    public void setLike(Like like) {
        this.like = like;
    }

    /**
     * @return the bid
     */
    public Bid getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(Bid bid) {
        this.bid = bid;
    }
    
    
}
