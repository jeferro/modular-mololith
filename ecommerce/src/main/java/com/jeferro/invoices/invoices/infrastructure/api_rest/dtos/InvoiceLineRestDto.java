package com.jeferro.invoices.invoices.infrastructure.api_rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineRestDto {

    private String productId;
    private BigDecimal productPrice;
    private Integer units;
}
