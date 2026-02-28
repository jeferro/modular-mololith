package com.jeferro.invoices.clients.infrastructure.rest_client.mappers;

import com.jeferro.invoices.clients.domain.Client;
import com.jeferro.invoices.clients.infrastructure.rest_client.dtos.ClientRestDto;
import org.mapstruct.Mapper;

@Mapper
public interface ClientRestMapper {

  Client toDomain(ClientRestDto dto);
}