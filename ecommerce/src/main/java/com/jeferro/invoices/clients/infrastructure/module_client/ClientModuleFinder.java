package com.jeferro.invoices.clients.infrastructure.module_client;

import com.jeferro.clients.infrastructure.module_api.ClientApi;
import com.jeferro.invoices.clients.domain.Client;
import com.jeferro.invoices.clients.domain.ClientFinder;
import com.jeferro.invoices.clients.infrastructure.module_client.mappers.ClientModuleMapper;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ClientModuleFinder implements ClientFinder {

  private final ClientApi clientApi;

  private final ClientModuleMapper mapper;

  @Override
  public Client findByIdOrError(String id) {
    var dto = clientApi.findByIdOrError(id);

    return mapper.toDTO(dto);
  }
}
