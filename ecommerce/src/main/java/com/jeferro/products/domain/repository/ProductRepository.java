package com.jeferro.products.domain.repository;

import com.jeferro.products.domain.exceptions.ProductNotFoundException;
import com.jeferro.products.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(String id);

    default Product findByIdOrError(String id) {
        return findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
