/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.sie.charity_network.POJOs.User;
import org.springframework.format.Formatter;

/**
 *
 * @author sie
 */
public class UserFormatter implements Formatter<User>{

    @Override
    public String print(User t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public User parse(String id, Locale locale) throws ParseException {
        User user = new User();
        user.setId(Integer.parseInt(id));
        return user;
    }
    
}
