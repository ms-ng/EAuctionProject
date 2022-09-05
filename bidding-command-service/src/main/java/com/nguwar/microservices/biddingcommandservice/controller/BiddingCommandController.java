package com.nguwar.microservices.biddingcommandservice.controller;

import com.nguwar.microservices.biddingcommandservice.dto.ProductBid;
import com.nguwar.microservices.biddingcommandservice.model.Bid;
import com.nguwar.microservices.biddingcommandservice.service.BiddingCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class BiddingCommandController {

    private BiddingCommandService biddingCommandService;

    @Autowired
    public BiddingCommandController(BiddingCommandService biddingCommandService) {
        this.biddingCommandService = biddingCommandService;
    }

    @PostMapping("/bidding-command-service/v1/place-bid")
    public ResponseEntity<String> placeBid(@RequestBody ProductBid productBid){
        Bid createdBid = biddingCommandService.addBid(productBid);
        return ResponseEntity.ok("new productBid placed : " + createdBid.getId());
    }

    @PutMapping("/bidding-command-service/v1/update-bid/{productId}/{buyerEmailId}/{newBidAmount}")
    public ResponseEntity<String> updateBid(@PathVariable Long productId,
                                                @PathVariable String buyerEmailId,
                                                @PathVariable BigDecimal newBidAmount){

        this.biddingCommandService.updateBid(productId,buyerEmailId,newBidAmount);
        return ResponseEntity.ok("bid price updated!");
    }


}
