package com.nguwar.microservices.productservice.model;

public enum ProductCategory {
    PAINTING("Painting"),
    SCULPTOR("Sculptor"),
    ORNAMENT("Ornament");

    private String value;

    ProductCategory(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
