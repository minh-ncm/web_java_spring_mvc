/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.sie.charity_network.POJOs.Post;
import org.springframework.format.Formatter;

/**
 *
 * @author sie
 */
public class PostFormatter implements Formatter<Post>{

    @Override
    public String print(Post t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Post parse(String id, Locale locale) throws ParseException {
        Post post = new Post();
        post.setId(Integer.parseInt(id));
        return post;
    }
    
}
