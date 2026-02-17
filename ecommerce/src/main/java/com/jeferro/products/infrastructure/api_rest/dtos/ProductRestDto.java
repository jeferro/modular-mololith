package com.jeferro.products.infrastructure.api_rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRestDto {

    private String id;
    private String name;
    private BigDecimal price;
}
