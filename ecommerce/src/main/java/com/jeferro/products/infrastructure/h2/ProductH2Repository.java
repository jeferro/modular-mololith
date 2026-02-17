package com.jeferro.products.infrastructure.h2;

import com.jeferro.products.domain.models.Product;
import com.jeferro.products.domain.repository.ProductRepository;
import com.jeferro.products.infrastructure.h2.mapper.ProductH2Mapper;
import com.jeferro.products.infrastructure.h2.repository.ProductH2PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductH2Repository implements ProductRepository {

    private final ProductH2PanacheRepository panacheRepository;

    private final ProductH2Mapper mapper;

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
