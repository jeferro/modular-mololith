package com.jeferro.products.infrastructure.h2.dtos;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products_products")
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ProductH2Entity {

    @Id
    private final String id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private final BigDecimal price;
}
