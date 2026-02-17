package com.jeferro.clients.infrastructure.module_contracts;

import com.jeferro.clients.application.GetClientUseCase;
import com.jeferro.clients.infrastructure.module_contracts.dtos.ClientContractDTO;
import com.jeferro.clients.infrastructure.module_contracts.mappers.ClientContractMapper;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ClientContract {

  private final GetClientUseCase getClientUseCase;

  private final ClientContractMapper mapper;

  public ClientContractDTO findByIdOrError(String id) {
    var client = getClientUseCase.execute(id);

    return mapper.toDTO(client);
  }
}
