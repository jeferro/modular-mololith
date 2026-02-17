package com.jeferro.invoices.invoices.domain.models;

import com.jeferro.invoices.clients.domain.Client;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Invoice {

  private final String id;
  private final ClientInfo client;
  private final LocalDate createdAt;
  private final LocalDate issuedAt;
  private final List<InvoiceLine> lines;

  public static Invoice create(Client client, List<InvoiceLine> lines) {
    var id = java.util.UUID.randomUUID().toString();
    var now = LocalDate.now();
    var clientInfo = ClientInfo.from(client);

    return new Invoice(id, clientInfo, now, now, lines);
  }
}
