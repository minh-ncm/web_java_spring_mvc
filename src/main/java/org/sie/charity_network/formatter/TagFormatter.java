/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.sie.charity_network.POJOs.Tag;
import org.springframework.format.Formatter;

/**
 *
 * @author sie
 */
public class TagFormatter implements Formatter<Tag>{

    @Override
    public String print(Tag tag, Locale locale) {
        return String.valueOf(tag.getId());
    }

    @Override
    public Tag parse(String tagId, Locale locale) throws ParseException {
        Tag tag = new Tag();
        tag.setId(Integer.parseInt(tagId));
        return tag;
    }
    
}
