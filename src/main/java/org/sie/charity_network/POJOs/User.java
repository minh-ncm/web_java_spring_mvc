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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sie
 */
@Entity
@Table(name = "users")
public class User implements Serializable{
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "user_role")
    private String userRole;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "is_reported")
    private Boolean isReport;
    @Transient
    private MultipartFile imageFile;
    @OneToMany(mappedBy = "reported")
    private List<Report> reportByList;
    @OneToMany(mappedBy = "reporter")
    private List<Report> reportList;
    @OneToMany(mappedBy = "owner")
    private List<Post> ownPostList;
    @OneToMany(mappedBy = "winner")
    private List<Post> wonPostList;
    @OneToMany(mappedBy = "user")
    private List<Like> likeList;
    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;
    @OneToMany(mappedBy = "user")
    private List<Bid> bidList;
    @Transient
    private Long unreadNotiAmount;

    public User() {
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the avatar_url
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl the avatar_url to set
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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
     * @return the isReport
     */
    public Boolean getIsReport() {
        return isReport;
    }

    /**
     * @param isReport the isReport to set
     */
    public void setIsReport(Boolean isReport) {
        this.isReport = isReport;
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

    /**
     * @return the reportSet
     */
    public List<Report> getReportList() {
        return reportList;
    }

    /**
     * @param reportList the reportSet to set
     */
    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    /**
     * @return the postSet
     */
    public List<Post> getOwnPostList() {
        return ownPostList;
    }

    /**
     * @param ownPostList the postSet to set
     */
    public void setOwnPostList(List<Post> ownPostList) {
        this.ownPostList = ownPostList;
    }

    /**
     * @return the wonPostSet
     */
    public List<Post> getWonPostList() {
        return wonPostList;
    }

    /**
     * @param wonPostList the wonPostSet to set
     */
    public void setWonPostList(List<Post> wonPostList) {
        this.wonPostList = wonPostList;
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
     * @return the reportByList
     */
    public List<Report> getReportByList() {
        return reportByList;
    }

    /**
     * @param reportByList the reportByList to set
     */
    public void setReportByList(List<Report> reportByList) {
        this.reportByList = reportByList;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the unreadNotiAmount
     */
    public Long getUnreadNotiAmount() {
        return unreadNotiAmount;
    }

    /**
     * @param unreadNotiAmount the unreadNotiAmount to set
     */
    public void setUnreadNotiAmount(Long unreadNotiAmount) {
        this.unreadNotiAmount = unreadNotiAmount;
    }
    
    
}
