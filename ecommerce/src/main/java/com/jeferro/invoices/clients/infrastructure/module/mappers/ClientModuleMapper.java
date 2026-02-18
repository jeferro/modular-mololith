package com.jeferro.invoices.clients.infrastructure.module.mappers;

import com.jeferro.clients.module_api.dtos.ClientApiDTO;
import com.jeferro.invoices.clients.domain.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientModuleMapper {

  Client toDTO(ClientApiDTO dto);
}
