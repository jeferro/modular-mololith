package com.jeferro.invoices.invoices.application;

import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.domain.repository.InvoiceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ListInvoicesUseCase {

    private final InvoiceRepository invoiceRepository;

    public List<Invoice> execute() {
        return invoiceRepository.findAll();
    }
}
