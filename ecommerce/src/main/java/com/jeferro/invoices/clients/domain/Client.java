package com.jeferro.invoices.clients.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Client {

    private final String id;
    private final PersonName name;
}
