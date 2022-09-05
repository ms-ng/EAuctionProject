package com.nguwar.microservices.biddingcommandservice.service;

import com.nguwar.microservices.biddingcommandservice.dto.CreatedProductBid;
import com.nguwar.microservices.biddingcommandservice.dto.Product;
import com.nguwar.microservices.biddingcommandservice.dto.ProductBid;
import com.nguwar.microservices.biddingcommandservice.model.Bid;
import com.nguwar.microservices.biddingcommandservice.proxy.ProductServiceProxy;
import com.nguwar.microservices.biddingcommandservice.repository.BiddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class BiddingCommandService {

    @Value("${kafka-topic-bid-created}")
    private String kafkaTopic_BidCreated;

    @Value("${kafka-topic-bid-updated}")
    private String kafkaTopic_BidUpdated;

    @Autowired
    private KafkaTemplate<Long, CreatedProductBid> kafkaTemplate;

    @Autowired
    private ProductServiceProxy productServiceProxy;

    private BiddingRepository biddingRepository;

    public BiddingCommandService(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }

    public Bid addBid(ProductBid productBid){
        Optional<Bid> optionalBid = Optional.empty();

        Product product = this.productServiceProxy.retrieveProduct(productBid.getProductId());

        if(product.getBidEndDate().isBefore(ZonedDateTime.now())) return null;

        Bid bid = new Bid();
        bid.setProductId(productBid.getProductId());
        bid.setFirstName(productBid.getFirstName());
        bid.setLastName(productBid.getLastName());
        bid.setEmail(productBid.getEmail());
        bid.setBidAmount(productBid.getBidAmount());
        Bid createdBid = this.biddingRepository.save(bid);

        CreatedProductBid createdProductBid = new CreatedProductBid();
        createdProductBid.setProductId(product.getId());
        createdProductBid.setBuyerFirstName(productBid.getFirstName());
        createdProductBid.setBuyerLastName(productBid.getLastName());
        createdProductBid.setBuyerEmail(productBid.getEmail());
        createdProductBid.setBidAmount(productBid.getBidAmount());

        this.sendMessage(kafkaTopic_BidCreated, createdProductBid);

        return createdBid;
    }

    public boolean updateBid(Long productId, String buyerEmailId, BigDecimal newBidAmount) {

        Optional<Bid> optionalBid = this.biddingRepository.findByProductIdAndEmail(productId,buyerEmailId);

        if(optionalBid.isPresent() == false) return false;

        Bid bid = optionalBid.get();

        Product product = this.productServiceProxy.retrieveProduct(productId);

        if(product.getBidEndDate().isBefore(ZonedDateTime.now())) return false;

        bid.setBidAmount(newBidAmount);
        this.biddingRepository.save(bid);

        CreatedProductBid createdProductBid = new CreatedProductBid();
        createdProductBid.setProductId(product.getId());
        createdProductBid.setBuyerFirstName(bid.getFirstName());
        createdProductBid.setBuyerLastName(bid.getLastName());
        createdProductBid.setBuyerEmail(bid.getEmail());
        createdProductBid.setBidAmount(bid.getBidAmount());

        this.sendMessage(kafkaTopic_BidUpdated, createdProductBid);

        return true;
    }

    public void sendMessage(String topicName, CreatedProductBid createdProductBid) {

        ListenableFuture<SendResult<Long, CreatedProductBid>> future =
                kafkaTemplate.send(topicName, createdProductBid.getProductId(), createdProductBid);

        future.addCallback(new ListenableFutureCallback<SendResult<Long, CreatedProductBid>>() {

            @Override
            public void onSuccess(SendResult<Long, CreatedProductBid> result) {
                System.out.println("Sent message=[" + createdProductBid.getProductId() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + createdProductBid.getProductId() + "] due to : " + ex.getMessage());
            }
        });
    }

}
