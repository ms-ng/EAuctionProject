package com.nguwar.microservices.biddingservice.service;

import com.nguwar.microservices.biddingservice.model.Bid;
import com.nguwar.microservices.biddingservice.repository.BiddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BiddingService {

    private BiddingRepository biddingRepository;

    @Autowired
    public BiddingService(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }

    public void addBid(Bid bid){
        this.biddingRepository.save(bid);
    }

    public void updateBid(Bid bid){
        this.biddingRepository.save(bid);
    }

    public Optional<Bid> getBid(Long productId, String buyerEmailId, BigDecimal newBidAmount){
        return this.biddingRepository.findById(productId);
    }
}
