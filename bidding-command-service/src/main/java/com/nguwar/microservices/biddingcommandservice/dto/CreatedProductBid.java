package com.nguwar.microservices.biddingcommandservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedProductBid {
    private Long productId;
    private String shortName;
    private String description;
    private String productCategory;
    private BigDecimal startingPrice;
    private ZonedDateTime bidEndDate;

    private String sellerFirstName;
    private String sellerLastName;
    private String sellerAddress;
    private String sellerCity;
    private String sellerState;
    private String sellerPostalCode;
    private String sellerPhone;
    private String sellerEmail;

    private long BidId;
    private String buyerFirstName;
    private String buyerLastName;
    private String buyerAddress;
    private String buyerCity;
    private String buyerState;
    private String buyerPostalCode;
    private String buyerPhone;
    private String buyerEmail;
    private BigDecimal bidAmount;
}
