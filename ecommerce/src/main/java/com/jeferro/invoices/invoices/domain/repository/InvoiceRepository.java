package com.jeferro.invoices.invoices.domain.repository;

import com.jeferro.invoices.invoices.domain.exceptions.InvoiceNotFoundException;
import com.jeferro.invoices.invoices.domain.models.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {

    List<Invoice> findAll();

    Optional<Invoice> findById(String id);

    default Invoice findByIdOrError(String id) {
        return findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
    }

    Invoice save(Invoice invoice);
}
