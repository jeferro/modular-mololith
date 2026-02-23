package com.jeferro.clients.domain.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Client {

    private final String id;
    private final PersonName name;
}
