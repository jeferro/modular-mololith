package com.jeferro.invoices.invoices.infrastructure.postgres.dtos;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ClientInfoPostgresDto {

    private final String id;
    private final String name;
}
