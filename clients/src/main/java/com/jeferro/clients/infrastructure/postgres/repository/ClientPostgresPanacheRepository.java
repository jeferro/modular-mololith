package com.jeferro.clients.infrastructure.postgres.repository;

import com.jeferro.clients.infrastructure.postgres.dtos.ClientPostgresEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientPostgresPanacheRepository implements PanacheRepositoryBase<ClientPostgresEntity, String> {
}
