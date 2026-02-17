package com.jeferro.products.infrastructure.module_contracts;

import com.jeferro.products.infrastructure.module_contracts.dtos.ProductContractDTO;
import com.jeferro.products.infrastructure.module_contracts.mappers.ProductContractMapper;
import com.jeferro.products.application.GetProductUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductContract {

  private final GetProductUseCase getProductUseCase;

  private final ProductContractMapper mapper;

  public ProductContractDTO findByIdOrError(String id) {
    var product = getProductUseCase.execute(id);

    return mapper.toDto(product);
  }
}
