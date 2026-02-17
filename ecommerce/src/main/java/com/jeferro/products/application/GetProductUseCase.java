package com.jeferro.products.application;

import com.jeferro.products.domain.models.Product;
import com.jeferro.products.domain.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class GetProductUseCase {

    private final ProductRepository productRepository;

    public Product execute(String id) {
        return productRepository.findByIdOrError(id);
    }
}
