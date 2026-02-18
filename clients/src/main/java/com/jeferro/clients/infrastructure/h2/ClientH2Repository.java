package com.jeferro.clients.infrastructure.h2;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.domain.repository.ClientRepository;
import com.jeferro.clients.infrastructure.h2.mapper.ClientH2Mapper;
import com.jeferro.clients.infrastructure.h2.repository.ClientH2PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class ClientH2Repository implements ClientRepository {

    private final ClientH2PanacheRepository panacheRepository;

    private final ClientH2Mapper mapper;

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
