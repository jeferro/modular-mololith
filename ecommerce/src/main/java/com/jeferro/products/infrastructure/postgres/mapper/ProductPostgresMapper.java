package com.jeferro.products.infrastructure.postgres.mapper;

import com.jeferro.products.domain.models.Product;
import com.jeferro.products.infrastructure.postgres.dtos.ProductPostgresEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPostgresMapper {

    Product toDomain(ProductPostgresEntity entity);
}
