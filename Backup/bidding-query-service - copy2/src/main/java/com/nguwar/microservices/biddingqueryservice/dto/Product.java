package com.nguwar.microservices.biddingqueryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String shortName;
    private String description;
    private String productCategory;
    private BigDecimal startingPrice;
    private ZonedDateTime bidEndDate;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String email;

    private List<Bid> bidList;
}
