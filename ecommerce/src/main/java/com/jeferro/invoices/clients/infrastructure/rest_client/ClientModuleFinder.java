package com.jeferro.invoices.clients.infrastructure.rest_client;

import com.jeferro.invoices.clients.domain.Client;
import com.jeferro.invoices.clients.domain.ClientFinder;
import com.jeferro.invoices.clients.infrastructure.rest_client.apis.ClientsRestApi;
import com.jeferro.invoices.clients.infrastructure.rest_client.mappers.ClientRestMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@RequiredArgsConstructor
public class ClientModuleFinder implements ClientFinder {

  @Inject
  @RestClient
  ClientsRestApi clientsRestApi;

  private final ClientRestMapper mapper;

  @Override
  public Client findByIdOrError(String id) {
    try {
      var dto = clientsRestApi.getById(id);

      return mapper.toDomain(dto);
    } catch (NotFoundException e) {
      return null;
    }
  }
}
