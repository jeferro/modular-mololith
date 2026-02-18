package com.jeferro.clients.module_api.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PersonNameApiDTO {

    private final String name;
    private final String firstSurname;
    private final String secondSurname;
}
