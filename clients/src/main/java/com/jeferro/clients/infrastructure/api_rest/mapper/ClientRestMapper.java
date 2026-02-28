package com.jeferro.clients.infrastructure.api_rest.mapper;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.infrastructure.api_rest.dtos.ClientRestDto;
import org.mapstruct.Mapper;

@Mapper
public interface ClientRestMapper {

    ClientRestDto toRestDto(Client domain);

    Client toDomain(ClientRestDto dto);
}
