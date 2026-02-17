package com.jeferro.invoices.invoices.infrastructure.h2;

import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.domain.repository.InvoiceRepository;
import com.jeferro.invoices.invoices.infrastructure.h2.mapper.InvoiceH2Mapper;
import com.jeferro.invoices.invoices.infrastructure.h2.repository.InvoiceH2PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class InvoiceH2Repository implements InvoiceRepository {

    private final InvoiceH2PanacheRepository panacheRepository;

    private final InvoiceH2Mapper mapper;

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
