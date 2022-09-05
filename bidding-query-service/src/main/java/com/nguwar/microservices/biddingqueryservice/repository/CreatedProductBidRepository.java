package com.nguwar.microservices.biddingqueryservice.repository;

import com.nguwar.microservices.biddingqueryservice.model.CreatedProductBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreatedProductBidRepository extends JpaRepository<CreatedProductBid, Long> {

    List<CreatedProductBid> findByProductId(Long productId);
}
