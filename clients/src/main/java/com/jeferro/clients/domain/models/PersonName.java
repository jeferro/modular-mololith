package com.jeferro.clients.domain.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PersonName {

    private final String name;
    private final String firstSurname;
    private final String secondSurname;
}
