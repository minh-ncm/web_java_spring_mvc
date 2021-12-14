/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.POJOs;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sie
 */
@Entity
@Table(name = "user")
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
    private Set<Report> reportSet;
    @OneToMany(mappedBy = "owner")
    private Set<Post> ownPostSet;
    @OneToMany(mappedBy = "winner")
    private Set<Post> wonPostSet;
    @OneToMany(mappedBy = "user")
    private Set<Like> likeSet;
    @OneToMany(mappedBy = "user")
    private Set<Comment> commentSet;

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
    public Set<Report> getReportSet() {
        return reportSet;
    }

    /**
     * @param reportSet the reportSet to set
     */
    public void setReportSet(Set<Report> reportSet) {
        this.reportSet = reportSet;
    }

    /**
     * @return the postSet
     */
    public Set<Post> getOwnPostSet() {
        return ownPostSet;
    }

    /**
     * @param ownPostSet the postSet to set
     */
    public void setOwnPostSet(Set<Post> ownPostSet) {
        this.ownPostSet = ownPostSet;
    }

    /**
     * @return the wonPostSet
     */
    public Set<Post> getWonPostSet() {
        return wonPostSet;
    }

    /**
     * @param wonPostSet the wonPostSet to set
     */
    public void setWonPostSet(Set<Post> wonPostSet) {
        this.wonPostSet = wonPostSet;
    }

    /**
     * @return the likeSet
     */
    public Set<Like> getLikeSet() {
        return likeSet;
    }

    /**
     * @param likeSet the likeSet to set
     */
    public void setLikeSet(Set<Like> likeSet) {
        this.likeSet = likeSet;
    }

    /**
     * @return the commentSet
     */
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    /**
     * @param commentSet the commentSet to set
     */
    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }
    
    
}
