package com.jeferro.invoices.clients.infrastructure.rest_client.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRestDTO {

    private String id;
    private PersonNameRestDTO name;
}
