/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import com.google.gson.Gson;
import com.mservice.allinone.models.PayGateRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sie.charity_network.POJOs.MomoRequest;
import org.sie.charity_network.POJOs.Post;
import org.sie.charity_network.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

/**
 *
 * @author sie
 */
@Service
public class PaymentServiceImplement implements PaymentService{
    @Autowired
    private Environment environment;

    @Override
    public MomoRequest createRequest(Post post) {
        MomoRequest request = new MomoRequest();
        
        request.setRequestId(UUID.randomUUID().toString().substring(0, 50));
        request.setAmount(new Long(150000));
        request.setOrderId(String.format("%s", post.getId()));
        request.setOrderInfo(String.format("Payment for %s", post.getTitle()));
        Map<String, String> extraData =  new HashMap<>();
        extraData.put("winner_id", String.format("%d", post.getWinner().getId()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        extraData.put("payment time", dateFormat.format(new Date()));
        request.setExtraData(request.generateExtraData(extraData));
        try {
            request.setSignature(request.generateSignature());
        } catch (Exception ex) {
            Logger.getLogger(PaymentServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return request;
    }

    
    
}
