package com.nguwar.microservices.biddingcommandservice.repository;

import com.nguwar.microservices.biddingcommandservice.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BiddingRepository extends JpaRepository<Bid, Long> {

    Optional<Bid> findByProductIdAndEmail(Long productId, String email);

}
