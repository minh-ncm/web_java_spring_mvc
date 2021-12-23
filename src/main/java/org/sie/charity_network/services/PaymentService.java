/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services;

import org.sie.charity_network.POJOs.MomoRequest;
import org.sie.charity_network.POJOs.Post;


/**
 *
 * @author sie
 */
public interface PaymentService {
    public MomoRequest createRequest(Post post);
}
