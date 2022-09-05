package com.nguwar.microservices.biddingqueryservice.controller;

import com.nguwar.microservices.biddingqueryservice.dto.Product;
import com.nguwar.microservices.biddingqueryservice.service.BiddingQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BiddingQueryController {

    private BiddingQueryService biddingQueryService;

    @Autowired
    public BiddingQueryController(BiddingQueryService biddingQueryService) {
        this.biddingQueryService = biddingQueryService;
    }

    @GetMapping("/bidding-query-service/v1/query/{productId}")
    public Product getProductBiddings(@PathVariable long productId){
        return biddingQueryService.getProductBiddings(productId);
    }

}
