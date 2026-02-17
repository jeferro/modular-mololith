package com.jeferro.invoices.clients.domain;

public interface ClientFinder {

  Client findByIdOrError(String id);
}
