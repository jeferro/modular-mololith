package com.jeferro.invoices.invoices.application;

import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.domain.repository.InvoiceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class GetInvoiceUseCase {

    private final InvoiceRepository invoiceRepository;

    public Invoice execute(String id) {
        return invoiceRepository.findByIdOrError(id);
    }
}
