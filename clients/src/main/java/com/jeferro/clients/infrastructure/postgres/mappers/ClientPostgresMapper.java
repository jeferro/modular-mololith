package com.jeferro.clients.infrastructure.postgres.mappers;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.infrastructure.postgres.dtos.ClientPostgresEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ClientPostgresMapper {

    Client toDomain(ClientPostgresEntity entity);
}
