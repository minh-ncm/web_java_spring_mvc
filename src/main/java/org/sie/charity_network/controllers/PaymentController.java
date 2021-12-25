/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import com.mservice.allinone.models.CaptureMoMoResponse;
import com.mservice.allinone.models.PayGateResponse;
import com.mservice.allinone.processor.allinone.CaptureMoMo;
import com.mservice.shared.sharedmodels.Environment;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.sie.charity_network.POJOs.Like;
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
    
    @GetMapping("test/momo2/")
    public String render(){
        return "momo";
    }
    
    @GetMapping("/test/momo/")
    public ResponseEntity<CaptureMoMoResponse> test() throws Exception{
        String orderId = "orderIdqwerqwerqwerq";
        String requestId = "requestIdqerqwerqweqqwer";
        String amount = String.valueOf(new BigDecimal(1e6));
        String orderInfo = "orderInfoqerqwerqwerqwer";
        String returnURL = "google.com";
        String notifyURL = "google.com";
        String extraData = "";
        
        Environment env = Environment.selectEnv("dev", Environment.ProcessType.PAY_GATE);
        CaptureMoMoResponse response = CaptureMoMo.process(env, orderId, requestId, amount, orderInfo, returnURL, notifyURL, extraData);
        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
