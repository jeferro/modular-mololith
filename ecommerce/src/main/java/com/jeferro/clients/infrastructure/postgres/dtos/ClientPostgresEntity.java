package com.jeferro.clients.infrastructure.postgres.dtos;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(schema = "clients", name = "clients")
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ClientPostgresEntity {

    @Id
    private final String id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name")),
            @AttributeOverride(name = "firstSurname", column = @Column(name = "first_surname")),
            @AttributeOverride(name = "secondSurname", column = @Column(name = "second_surname"))
    })
    private final PersonNamePostgresDto name;
}
