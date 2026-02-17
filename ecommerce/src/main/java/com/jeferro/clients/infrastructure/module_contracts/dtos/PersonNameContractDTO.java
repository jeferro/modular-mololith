package com.jeferro.clients.infrastructure.module_contracts.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PersonNameContractDTO {

    private final String name;
    private final String firstSurname;
    private final String secondSurname;
}
