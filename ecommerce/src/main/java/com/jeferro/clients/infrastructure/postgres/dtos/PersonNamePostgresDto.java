package com.jeferro.clients.infrastructure.postgres.dtos;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PersonNamePostgresDto {

    private final String name;
    private final String firstSurname;
    private final String secondSurname;
}
