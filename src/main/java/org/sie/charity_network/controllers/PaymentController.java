/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import org.sie.charity_network.POJOs.MomoRequest;
import org.sie.charity_network.POJOs.Post;
import org.sie.charity_network.services.PaymentService;
import org.sie.charity_network.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sie
 */
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PostService postService;
    
    @GetMapping("/test/")
    public ResponseEntity<MomoRequest> test(){
        MomoRequest momoRequest = paymentService.createRequest(postService.getPost(1));
        return new ResponseEntity<>(
                momoRequest,
                HttpStatus.OK
        );
    }
}
