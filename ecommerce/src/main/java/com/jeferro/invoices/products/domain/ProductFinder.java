package com.jeferro.invoices.products.domain;

public interface ProductFinder {

  Product findByIdOrError(String id);
}
