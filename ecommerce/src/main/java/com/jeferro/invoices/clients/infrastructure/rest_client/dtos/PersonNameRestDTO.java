package com.jeferro.invoices.clients.infrastructure.rest_client.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonNameRestDTO {

    private String name;
    private String firstSurname;
    private String secondSurname;
}
