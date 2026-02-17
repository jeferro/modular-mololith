package com.jeferro.products.infrastructure.module_contracts.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class ProductContractDTO {

    private final String id;
    private final String name;
    private final BigDecimal price;
}
