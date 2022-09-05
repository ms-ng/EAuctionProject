package com.nguwar.microservices.biddingservice.repository;

import com.nguwar.microservices.biddingservice.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiddingRepository extends JpaRepository<Bid, Long> {


}
