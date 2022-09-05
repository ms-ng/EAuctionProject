package com.nguwar.microservices.biddingcommandservice.service;

import com.nguwar.microservices.biddingcommandservice.dto.Bid;
import com.nguwar.microservices.biddingcommandservice.dto.Product;
import com.nguwar.microservices.biddingcommandservice.proxy.BiddingServiceProxy;
import com.nguwar.microservices.biddingcommandservice.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Service
public class BiddingCommandService {

    //@Autowired
    //private ProductServiceProxy productServiceProxy;
    //@Autowired
    //private BiddingServiceProxy biddingServiceProxy;

    @Autowired
    private KafkaTemplate<Long, Bid> kafkaTemplate;

    public boolean addBid(Bid bid){
        //Product product = this.productServiceProxy.retrieveProduct(bid.getProductId());

        //if(product.getBidEndDate().isBefore(ZonedDateTime.now())) return false;

        //this.biddingServiceProxy.placeBid(bid);

        this.sendMessage("bid-created-testtest", bid);

        return true;
    }

    public boolean updateBid(Long productId, String buyerEmailId, BigDecimal newBidAmount) {
        //this.biddingServiceProxy.updateBid(productId, buyerEmailId, newBidAmount);

        this.sendMessage("bid-updated", new Bid());

        return true;
    }

    public void sendMessage(String topic, Bid bid) {
        kafkaTemplate.send(topic, bid.getProductId(), bid);
    }

}
