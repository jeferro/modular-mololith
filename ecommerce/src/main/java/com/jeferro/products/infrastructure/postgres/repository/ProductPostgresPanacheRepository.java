package com.jeferro.products.infrastructure.postgres.repository;

import com.jeferro.products.infrastructure.postgres.dtos.ProductPostgresEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductPostgresPanacheRepository implements PanacheRepositoryBase<ProductPostgresEntity, String> {
}
