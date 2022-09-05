package com.nguwar.microservices.biddingcommandservice.proxy;

import com.nguwar.microservices.biddingcommandservice.dto.Bid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name="bidding-service")
public interface BiddingServiceProxy {

    @PostMapping("/bidding-service/v1/place-bid")
    public ResponseEntity<String> placeBid(@RequestBody Bid bid);

    @PutMapping("/bidding-service/v1/update-bid/{productId}/{buyerEmailId}/{newBidAmount}")
    public ResponseEntity<String> updateBid(@PathVariable Long productId,
                                            @PathVariable String buyerEmailId,
                                            @PathVariable BigDecimal newBidAmount);
}
