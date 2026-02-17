package com.jeferro.clients.infrastructure.h2.dtos;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "clients_clients")
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ClientH2Entity {

    @Id
    private final String id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name")),
            @AttributeOverride(name = "firstSurname", column = @Column(name = "first_surname")),
            @AttributeOverride(name = "secondSurname", column = @Column(name = "second_surname"))
    })
    private final PersonNameH2Dto name;
}
