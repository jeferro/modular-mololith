package com.jeferro.invoices.invoices.infrastructure.api_rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineInputRestDto {

    private String productId;
    private Integer units;
}
