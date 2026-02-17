package com.jeferro.clients.infrastructure.api_rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonNameRestDto {

    private String name;
    private String firstSurname;
    private String secondSurname;
}
