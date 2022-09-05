package com.nguwar.microservices.biddingqueryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="created-product-bid")
public class CreatedProductBid {
    @Id
    @GeneratedValue
    private Long Id;
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
