package com.jeferro.invoices.invoices.infrastructure.postgres.dtos;

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
public class InvoiceLinePostgresDto {

    private final String productId;
    private final BigDecimal productPrice;
    private final Integer units;
}
