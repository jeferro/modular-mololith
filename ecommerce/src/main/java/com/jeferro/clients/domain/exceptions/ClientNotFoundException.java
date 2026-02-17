package com.jeferro.clients.domain.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String id) {
        super("Client not found with id: " + id);
    }
}
