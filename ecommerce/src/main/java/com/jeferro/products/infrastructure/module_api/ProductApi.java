package com.jeferro.products.infrastructure.module_api;

import com.jeferro.products.infrastructure.module_api.dtos.ProductApiDTO;
import com.jeferro.products.infrastructure.module_api.mappers.ProductApiMapper;
import com.jeferro.products.application.GetProductUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductApi {

  private final GetProductUseCase getProductUseCase;

  private final ProductApiMapper mapper;

  public ProductApiDTO findByIdOrError(String id) {
    var product = getProductUseCase.execute(id);

    return mapper.toDto(product);
  }
}
