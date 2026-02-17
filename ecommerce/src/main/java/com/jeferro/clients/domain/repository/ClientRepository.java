package com.jeferro.clients.domain.repository;

import com.jeferro.clients.domain.exceptions.ClientNotFoundException;
import com.jeferro.clients.domain.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> findAll();

    Optional<Client> findById(String id);

    default Client findByIdOrError(String id) {
        return findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }
}
