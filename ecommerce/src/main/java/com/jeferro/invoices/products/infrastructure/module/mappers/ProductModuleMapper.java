package com.jeferro.invoices.products.infrastructure.module.mappers;

import com.jeferro.invoices.products.domain.Product;
import com.jeferro.products.module_api.dtos.ProductApiDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductModuleMapper {

  Product toDTO(ProductApiDTO dto);
}
