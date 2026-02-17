package com.jeferro.invoices.products.infrastructure.module.mappers;

import com.jeferro.invoices.products.domain.Product;
import com.jeferro.products.infrastructure.module_contracts.dtos.ProductContractDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductModuleMapper {

  Product toDTO(ProductContractDTO dto);
}
