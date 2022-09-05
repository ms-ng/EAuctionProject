package com.nguwar.microservices.productservice.service;

import com.nguwar.microservices.productservice.exception.ProductDeletionException;
import com.nguwar.microservices.productservice.model.Product;
import com.nguwar.microservices.productservice.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductService underTest;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        underTest = new ProductService(productRepository);
    }

    @AfterEach
    void tearDown(){
    }

    /*
    @Test
    void canAddProduct() {
        //Given
        Product product = new Product();
        //When
        underTest.addProduct(product);
        //Then
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(captor.capture());
        Product savedProduct = captor.getValue();
        assertThat(savedProduct).isEqualTo(product);

    }

    @Test
    void willThrowErrorWhenAddingProduct() {
        //Given
        Product product = new Product();

        given(productRepository.findById(anyLong())).willReturn(null);
        //When
        //Then
        assertThatThrownBy(() -> underTest.addProduct(product))
                .isInstanceOf(ProductDeletionException.class)
                .hasMessageContaining("blah blah");

        verify(productRepository, never()).save(any());
    }

    @Test
    void canGetProduct() {
        //Given
        //when
        //underTest.getProduct(1);
        //then
        //verify(productRepository).findById(1L);

        // Given that the repository returns CHECKED_ITEM and UNCHECKED_ITEM
        //given(productRepository.findById(1L)).willReturn(new Product());
        // When looking for all items
        //assertThat(underTest.getProduct(1))
        // Then it should return the CHECKED_ITEM and UNCHECKED_ITEM
        //.containsOnly(CHECKED_ITEM, UNCHECKED_ITEM);

    }

    @Test
    @Disabled
    void deleteProduct() {
    }

     */
}