package com.jeferro.clients.infrastructure.module_contracts.mappers;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.infrastructure.module_contracts.dtos.ClientContractDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ClientContractMapper {

  ClientContractDTO toDTO(Client client);
}
