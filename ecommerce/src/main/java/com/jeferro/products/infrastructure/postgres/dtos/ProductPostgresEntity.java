package com.jeferro.products.infrastructure.postgres.dtos;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(schema = "products", name = "products")
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ProductPostgresEntity {

    @Id
    private final String id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private final BigDecimal price;
}
