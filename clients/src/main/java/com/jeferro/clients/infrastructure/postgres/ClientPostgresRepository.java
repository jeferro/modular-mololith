package com.jeferro.clients.infrastructure.postgres;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.domain.repository.ClientRepository;
import com.jeferro.clients.infrastructure.postgres.mappers.ClientPostgresMapper;
import com.jeferro.clients.infrastructure.postgres.repository.ClientPostgresPanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class ClientPostgresRepository implements ClientRepository {

    private final ClientPostgresPanacheRepository panacheRepository;

    private final ClientPostgresMapper mapper;

    @Override
    public List<Client> findAll() {
        return panacheRepository.listAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Client> findById(String id) {
        return panacheRepository.findByIdOptional(id)
                .map(mapper::toDomain);
    }
}
