package com.nguwar.microservices.biddingservice.controller;

import com.nguwar.microservices.biddingservice.model.Bid;
import com.nguwar.microservices.biddingservice.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class BiddingController {

    private BiddingService biddingService;

    @Autowired
    public BiddingController(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    //@PostMapping("/e-auction/api/v1/buyer/place-bid")
    @PostMapping("/bidding-service/v1/place-bid")
    public ResponseEntity<String> placeBid(@RequestBody Bid bid){
        biddingService.addBid(bid);
        return ResponseEntity.ok("new bid placed!");
    }

    //@PutMapping ("/e-auction/api/v1/buyer/update-bid/{productId}/{buyerEmailId}/{newBidAmount}")
    @PutMapping ("/bidding-service/v1/update-bid/{productId}/{buyerEmailId}/{newBidAmount}")
    public ResponseEntity<String> updateBid(@PathVariable Long productId,
                                                @PathVariable String buyerEmailId,
                                                @PathVariable BigDecimal newBidAmount){

        Optional<Bid> bid = this.biddingService.getBid(productId,buyerEmailId, newBidAmount);

        if(bid.isPresent() == false)
            return ResponseEntity.notFound().build();

        this.biddingService.updateBid(bid.get());

        return ResponseEntity.ok("bid price updated!");
    }


}
