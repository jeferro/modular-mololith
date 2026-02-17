package com.jeferro.products.infrastructure.module_api.mappers;

import com.jeferro.products.infrastructure.module_api.dtos.ProductApiDTO;
import com.jeferro.products.domain.models.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductApiMapper {

  ProductApiDTO toDto(Product product);
}
