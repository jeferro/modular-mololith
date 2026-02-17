package com.jeferro.invoices.invoices.application;

import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.domain.models.InvoiceLineInput;
import com.jeferro.invoices.invoices.domain.services.InvoiceCreator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CreateInvoiceUseCase {

    private final InvoiceCreator invoiceCreator;

    @Transactional
    public Invoice execute(String clientId, List<InvoiceLineInput> linesInput) {
        return invoiceCreator.create(clientId, linesInput);
    }
}
