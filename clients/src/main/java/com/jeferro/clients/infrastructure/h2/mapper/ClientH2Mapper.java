package com.jeferro.clients.infrastructure.h2.mapper;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.infrastructure.h2.dtos.ClientH2Entity;
import org.mapstruct.Mapper;

@Mapper
public interface ClientH2Mapper {

    Client toDomain(ClientH2Entity entity);
}
