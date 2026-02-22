package com.jeferro.invoices.invoices.infrastructure.postgres.repository;

import com.jeferro.invoices.invoices.infrastructure.postgres.dtos.InvoicePostgresEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvoicePostgresPanacheRepository implements PanacheRepositoryBase<InvoicePostgresEntity, String> {
}
