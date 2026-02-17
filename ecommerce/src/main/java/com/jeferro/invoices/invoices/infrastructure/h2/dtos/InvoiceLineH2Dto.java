package com.jeferro.invoices.invoices.infrastructure.h2.dtos;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class InvoiceLineH2Dto {

    private final String productId;
    private final BigDecimal productPrice;
    private final Integer units;
}
