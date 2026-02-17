package com.jeferro.products.infrastructure.h2.repository;

import com.jeferro.products.infrastructure.h2.dtos.ProductH2Entity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductH2PanacheRepository implements PanacheRepositoryBase<ProductH2Entity, String> {
}
