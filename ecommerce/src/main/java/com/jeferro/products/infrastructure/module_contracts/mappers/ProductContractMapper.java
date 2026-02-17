package com.jeferro.products.infrastructure.module_contracts.mappers;

import com.jeferro.products.infrastructure.module_contracts.dtos.ProductContractDTO;
import com.jeferro.products.domain.models.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductContractMapper {

  ProductContractDTO toDto(Product product);
}
