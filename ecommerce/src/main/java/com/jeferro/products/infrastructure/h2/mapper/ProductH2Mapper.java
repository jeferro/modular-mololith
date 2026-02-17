package com.jeferro.products.infrastructure.h2.mapper;

import com.jeferro.products.domain.models.Product;
import com.jeferro.products.infrastructure.h2.dtos.ProductH2Entity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductH2Mapper {

    Product toDomain(ProductH2Entity entity);
}
