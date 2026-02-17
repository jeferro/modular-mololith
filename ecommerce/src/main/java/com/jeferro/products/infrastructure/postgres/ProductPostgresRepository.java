package com.jeferro.products.infrastructure.postgres;

import com.jeferro.products.domain.models.Product;
import com.jeferro.products.domain.repository.ProductRepository;
import com.jeferro.products.infrastructure.postgres.mapper.ProductPostgresMapper;
import com.jeferro.products.infrastructure.postgres.repository.ProductPostgresPanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductPostgresRepository implements ProductRepository {

    private final ProductPostgresPanacheRepository panacheRepository;

    private final ProductPostgresMapper mapper;

    @Override
    public List<Product> findAll() {
        return panacheRepository.listAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(String id) {
        return panacheRepository.findByIdOptional(id)
                .map(mapper::toDomain);
    }
}
