package com.jeferro.invoices.invoices.domain.exceptions;

public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(String id) {
        super("Invoice not found with id: " + id);
    }
}
