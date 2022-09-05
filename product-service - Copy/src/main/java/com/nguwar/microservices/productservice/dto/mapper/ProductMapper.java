package com.nguwar.microservices.productservice.dto.mapper;

import com.nguwar.microservices.productservice.dto.ProductDTO;
import com.nguwar.microservices.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);
}
