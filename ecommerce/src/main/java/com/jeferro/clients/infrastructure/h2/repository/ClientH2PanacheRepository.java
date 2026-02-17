package com.jeferro.clients.infrastructure.h2.repository;

import com.jeferro.clients.infrastructure.h2.dtos.ClientH2Entity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientH2PanacheRepository implements PanacheRepositoryBase<ClientH2Entity, String> {
}
