package com.jeferro.clients.infrastructure.api_rest.dtos;

import com.jeferro.clients.infrastructure.api_rest.dtos.PersonNameRestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRestDto {

    private String id;
    private PersonNameRestDto name;
}
