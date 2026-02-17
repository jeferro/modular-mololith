package com.jeferro.invoices.products.infrastructure.module;

import com.jeferro.invoices.products.domain.Product;
import com.jeferro.invoices.products.domain.ProductFinder;
import com.jeferro.invoices.products.infrastructure.module.mappers.ProductModuleMapper;
import com.jeferro.products.infrastructure.module_contracts.ProductContract;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductModuleFinder implements ProductFinder {

  private final ProductContract productContract;

  private final ProductModuleMapper mapper;

  @Override
  public Product findByIdOrError(String id) {
    var dto = productContract.findByIdOrError(id);

    return mapper.toDTO(dto);
  }
}
