package com.jeferro.products.application;

import com.jeferro.products.domain.models.Product;
import com.jeferro.products.domain.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ListProductsUseCase {

    private final ProductRepository productRepository;

    public List<Product> execute() {
        return productRepository.findAll();
    }
}
