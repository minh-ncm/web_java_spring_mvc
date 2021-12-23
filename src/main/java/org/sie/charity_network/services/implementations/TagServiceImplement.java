/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import java.util.List;
import org.sie.charity_network.POJOs.Tag;
import org.sie.charity_network.repositories.TagRepository;
import org.sie.charity_network.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sie
 */
@Service
public class TagServiceImplement implements TagService{
    @Autowired
    private TagRepository tagRepository;

    @Override
    public boolean addTag(Tag tag) {
        return tagRepository.addTag(tag);
    }

    @Override
    public List<Tag> getTagList() {
        return tagRepository.getTagList();
    }
    
    
}
