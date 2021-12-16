/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import java.util.Date;
import org.sie.charity_network.POJOs.Bid;
import org.sie.charity_network.services.BidService;
import org.sie.charity_network.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sie
 */
@Service
public class BidServiceImplement implements BidService{
    @Autowired
    private BidRepository bidRepository;

    @Override
    public void addBid(Bid bid) {
        bid.setCreatedDate(new Date());
        bidRepository.addBid(bid);
    }
    
}
