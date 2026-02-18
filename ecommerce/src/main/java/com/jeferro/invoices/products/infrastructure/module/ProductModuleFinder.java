package com.jeferro.invoices.products.infrastructure.module;

import com.jeferro.invoices.products.domain.Product;
import com.jeferro.invoices.products.domain.ProductFinder;
import com.jeferro.invoices.products.infrastructure.module.mappers.ProductModuleMapper;
import com.jeferro.products.module_api.ProductApi;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductModuleFinder implements ProductFinder {

  private final ProductApi productApi;

  private final ProductModuleMapper mapper;

  @Override
  public Product findByIdOrError(String id) {
    var dto = productApi.findByIdOrError(id);

    return mapper.toDTO(dto);
  }
}
