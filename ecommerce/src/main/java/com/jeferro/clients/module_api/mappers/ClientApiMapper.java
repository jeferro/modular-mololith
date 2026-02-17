package com.jeferro.clients.module_api.mappers;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.module_api.dtos.ClientApiDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ClientApiMapper {

  ClientApiDTO toDTO(Client client);
}
