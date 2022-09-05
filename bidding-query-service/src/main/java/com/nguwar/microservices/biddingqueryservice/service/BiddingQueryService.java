package com.nguwar.microservices.biddingqueryservice.service;

import com.nguwar.microservices.biddingqueryservice.dto.Bid;
import com.nguwar.microservices.biddingqueryservice.dto.Product;
import com.nguwar.microservices.biddingqueryservice.model.CreatedProductBid;
import com.nguwar.microservices.biddingqueryservice.repository.CreatedProductBidRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiddingQueryService {

    private CreatedProductBidRepository createdProductBidRepository;

    public BiddingQueryService(CreatedProductBidRepository createdProductBidRepository){
        this.createdProductBidRepository = createdProductBidRepository;
    }

    public Product getProductBiddings(Long productId){

        List<CreatedProductBid> list = this.createdProductBidRepository.findByProductId(productId);

        Product product = new Product();

        product.setId(productId);
        for(CreatedProductBid createdProductBid : list) {
            Bid bid = new Bid();
            bid.setId(createdProductBid.getBidId());
            bid.setEmail(createdProductBid.getBuyerEmail());
            bid.setFirstName(createdProductBid.getBuyerFirstName());
            bid.setLastName(createdProductBid.getBuyerLastName());
            bid.setBidAmount(createdProductBid.getBidAmount());
            product.getBidList().add(bid);
        }

        return product;
    }
}
