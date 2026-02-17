package com.jeferro.clients.module_api;

import com.jeferro.clients.application.GetClientUseCase;
import com.jeferro.clients.module_api.dtos.ClientApiDTO;
import com.jeferro.clients.module_api.mappers.ClientApiMapper;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ClientApi {

  private final GetClientUseCase getClientUseCase;

  private final ClientApiMapper mapper;

  public ClientApiDTO findByIdOrError(String id) {
    var client = getClientUseCase.execute(id);

    return mapper.toDTO(client);
  }
}
