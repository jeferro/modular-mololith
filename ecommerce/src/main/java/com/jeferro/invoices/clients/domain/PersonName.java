package com.jeferro.invoices.clients.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PersonName {

    private final String name;
    private final String firstSurname;
    private final String secondSurname;

    public String getFullName() {
        return String.format("%s %s %s", name, firstSurname, secondSurname).trim();
    }
}
