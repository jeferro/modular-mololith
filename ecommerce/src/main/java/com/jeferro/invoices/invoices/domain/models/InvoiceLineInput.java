package com.jeferro.invoices.invoices.domain.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class InvoiceLineInput {
  private final String productId;

  private final Integer units;
}
