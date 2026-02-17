package com.jeferro.invoices.clients.infrastructure.module_client.mappers;

import com.jeferro.clients.infrastructure.module_api.dtos.ClientApiDTO;
import com.jeferro.invoices.clients.domain.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientModuleMapper {

  Client toDTO(ClientApiDTO dto);
}
