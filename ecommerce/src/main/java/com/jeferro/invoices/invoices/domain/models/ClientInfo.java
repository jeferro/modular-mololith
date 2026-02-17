package com.jeferro.invoices.invoices.domain.models;

import com.jeferro.invoices.clients.domain.Client;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ClientInfo {

    private final String id;
    private final String name;

    public static ClientInfo from(Client client) {
        return new ClientInfo(client.getId(), client.getName().getFullName());
    }
}
