package com.nguwar.microservices.productservice.repository;

import com.nguwar.microservices.productservice.model.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }

    /*
    @Test
    void getProduct(){
        //given
        Product product = new Product();
        productRepository.save(product);
        //when
        boolean expected = productRepository.existsById(1L);
        //then
        assertThat(expected).isTrue();

    }

    @Test
    void getProductEmailNotExisted(){
        //given
        Product product = new Product();
        //when
        boolean expected = productRepository.existsById(1L);
        //then
        assertThat(expected).isFalse();

    }

     */

}