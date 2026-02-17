package com.jeferro.invoices.clients.infrastructure.module;

import com.jeferro.clients.infrastructure.module_contracts.ClientContract;
import com.jeferro.invoices.clients.domain.Client;
import com.jeferro.invoices.clients.domain.ClientFinder;
import com.jeferro.invoices.clients.infrastructure.module.mappers.ClientModuleMapper;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ClientModuleFinder implements ClientFinder {

  private final ClientContract clientContract;

  private final ClientModuleMapper mapper;

  @Override
  public Client findByIdOrError(String id) {
    var dto = clientContract.findByIdOrError(id);

    return mapper.toDTO(dto);
  }
}
