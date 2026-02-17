package com.jeferro.invoices.invoices.domain.models;

import com.jeferro.invoices.products.domain.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class InvoiceLine {

    private final String productId;
    private final BigDecimal productPrice;
    private final Integer units;

    public static InvoiceLine create(Product product, Integer units) {
        return new InvoiceLine(product.getId(), product.getPrice(), units);
    }
}
