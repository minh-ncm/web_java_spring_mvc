/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.POJOs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sie
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 10, max = 300, message = "{post.description.size}")
    private String description;
    @Size(min = 5, max = 50, message = "{post.title.size}")
    private String title;
    private String imageUrl;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
    @ManyToOne
    @JoinColumn(name = "winner_id")
    private User winner;
    @OneToMany(mappedBy = "post")
    private List<Like> likeList;
    @OneToMany(mappedBy = "post")
    private List<Comment> commentList;
    @OneToMany(mappedBy = "post")
    private List<Bid> bidList;
    @Transient
    private MultipartFile imageFile;

    public Post() {
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the user
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @param owner the user to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * @return the winner
     */
    public User getWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(User winner) {
        this.winner = winner;
    }

    /**
     * @return the likeSet
     */
    public List<Like> getLikeList() {
        return likeList;
    }

    /**
     * @param likeList the likeSet to set
     */
    public void setLikeList(List<Like> likeList) {
        this.likeList = likeList;
    }

    /**
     * @return the commentSet
     */
    public List<Comment> getCommentList() {
        return commentList;
    }

    /**
     * @param commentList the commentSet to set
     */
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    /**
     * @return the bidList
     */
    public List<Bid> getBidList() {
        return bidList;
    }

    /**
     * @param bidList the bidList to set
     */
    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    /**
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return the imageFile
     */
    public MultipartFile getImageFile() {
        return imageFile;
    }

    /**
     * @param imageFile the imageFile to set
     */
    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
    
    
}
