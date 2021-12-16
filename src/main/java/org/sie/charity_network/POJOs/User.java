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
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sie
 */
@Entity
@Table(name = "users")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=4, max=20, message="{user.username.size}")
    private String username;
    @Size(min=8, max=30, message="{user.password.size}")
    private String password;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "is_admin")
    private Boolean isAdmin;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "is_reported")
    private Boolean isReport;
    @Transient
    private MultipartFile imageFile;
    @OneToMany(mappedBy = "reported")
    private List<Report> reportList;
    @OneToMany(mappedBy = "owner")
    private List<Post> ownPostList;
    @OneToMany(mappedBy = "winner")
    private List<Post> wonPostList;
    @OneToMany(mappedBy = "user")
    private List<Like> likeList;
    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;

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
     * @return the isAdmin
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
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
    
    
}
