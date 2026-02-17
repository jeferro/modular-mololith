package com.jeferro.invoices.products.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class Product {

    private final String id;
    private final String name;
    private final BigDecimal price;
}
