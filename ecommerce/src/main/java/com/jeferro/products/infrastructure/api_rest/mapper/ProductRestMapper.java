package com.jeferro.products.infrastructure.api_rest.mapper;

import com.jeferro.products.domain.models.Product;
import com.jeferro.products.infrastructure.api_rest.dtos.ProductRestDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRestMapper {

    ProductRestDto toRestDto(Product domain);

    Product toDomain(ProductRestDto dto);
}
