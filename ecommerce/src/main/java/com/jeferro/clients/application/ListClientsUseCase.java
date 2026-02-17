package com.jeferro.clients.application;

import com.jeferro.clients.domain.models.Client;
import com.jeferro.clients.domain.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ListClientsUseCase {

    private final ClientRepository clientRepository;

    public List<Client> execute() {
        return clientRepository.findAll();
    }
}
