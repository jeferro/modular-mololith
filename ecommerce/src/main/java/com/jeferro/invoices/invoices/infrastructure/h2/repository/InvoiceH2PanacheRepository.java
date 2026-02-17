package com.jeferro.invoices.invoices.infrastructure.h2.repository;

import com.jeferro.invoices.invoices.infrastructure.h2.dtos.InvoiceH2Entity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvoiceH2PanacheRepository implements PanacheRepositoryBase<InvoiceH2Entity, String> {
}
