package com.jeferro.invoices.invoices.infrastructure.postgres;

import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.domain.repository.InvoiceRepository;
import com.jeferro.invoices.invoices.infrastructure.postgres.mapper.InvoicePostgresMapper;
import com.jeferro.invoices.invoices.infrastructure.postgres.repository.InvoicePostgresPanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class InvoicePostgresRepository implements InvoiceRepository {

    private final InvoicePostgresPanacheRepository panacheRepository;

    private final InvoicePostgresMapper mapper;

    @Override
    public List<Invoice> findAll() {
        return panacheRepository.listAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Invoice> findById(String id) {
        return panacheRepository.findByIdOptional(id)
                .map(mapper::toDomain);
    }

    @Override
    public Invoice save(Invoice invoice) {
        var entity = mapper.toEntity(invoice);
        panacheRepository.persist(entity);
        return mapper.toDomain(entity);
    }
}
