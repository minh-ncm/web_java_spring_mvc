/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.POJOs;


/**
 *
 * @author sie
 */
public class OutputMessaage {
    private String text;
    private String from;
    private String time;

    public OutputMessaage() {
    }

    public OutputMessaage(String from, String message, String date) {
        this.text = message;
        this.from = from;
        this.time = date;
    }

    /**
     * @return the message
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the message to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the date
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the date to set
     */
    public void setTime(String time) {
        this.time = time;
    }
    
    
}
