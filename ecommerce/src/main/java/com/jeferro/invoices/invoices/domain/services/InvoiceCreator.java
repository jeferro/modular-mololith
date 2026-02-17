package com.jeferro.invoices.invoices.domain.services;

import com.jeferro.invoices.clients.domain.ClientFinder;
import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.domain.models.InvoiceLine;
import com.jeferro.invoices.invoices.domain.models.InvoiceLineInput;
import com.jeferro.invoices.invoices.domain.repository.InvoiceRepository;
import com.jeferro.invoices.products.domain.ProductFinder;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class InvoiceCreator {

  private final ClientFinder clientFinder;

  private final ProductFinder productFinder;

  private final InvoiceRepository invoiceRepository;

  public Invoice create(String clientId, List<InvoiceLineInput> linesInput) {
    var client = clientFinder.findByIdOrError(clientId);

    var lines = linesInput.stream()
            .map(this::createInvoiceLine)
            .toList();

    var invoice = Invoice.create(client, lines);

    return invoiceRepository.save(invoice);
  }

  private InvoiceLine createInvoiceLine(InvoiceLineInput input) {
    var product = productFinder.findByIdOrError(input.getProductId());

    return InvoiceLine.create(product, input.getUnits());
  }
}
