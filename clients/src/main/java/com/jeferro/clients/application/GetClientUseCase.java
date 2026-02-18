package com.jeferro.clients.application;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.domain.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class GetClientUseCase {

    private final ClientRepository clientRepository;

    public Client execute(String id) {
        return clientRepository.findByIdOrError(id);
    }
}
