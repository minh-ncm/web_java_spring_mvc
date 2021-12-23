/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.POJOs;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author sie
 */
@Entity
@Table(name = "tags")
public class Tag implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String type;
    @ManyToMany(mappedBy = "tagList")
    private List<Post> postList;

    public Tag() {
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the postList
     */
    public List<Post> getPostList() {
        return postList;
    }

    /**
     * @param postList the postList to set
     */
    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
    
    
}
