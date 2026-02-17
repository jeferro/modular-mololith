package com.jeferro.clients.infrastructure.h2.dtos;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PersonNameH2Dto {

    private final String name;
    private final String firstSurname;
    private final String secondSurname;
}
