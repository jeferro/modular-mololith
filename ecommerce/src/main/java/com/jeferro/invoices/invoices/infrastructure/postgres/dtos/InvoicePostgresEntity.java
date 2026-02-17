package com.jeferro.invoices.invoices.infrastructure.postgres.dtos;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(schema = "invoices", name = "invoices")
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class InvoicePostgresEntity {

    @Id
    private final String id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "client_id")),
            @AttributeOverride(name = "name", column = @Column(name = "client_name"))
    })
    private final ClientInfoPostgresDto client;

    @Column(name = "created_at", nullable = false)
    private final LocalDate createdAt;

    @Column(name = "issued_at", nullable = false)
    private final LocalDate issuedAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            schema = "invoices",
            name = "invoice_lines",
            joinColumns = @JoinColumn(name = "invoice_id")
    )
    @AttributeOverrides({
            @AttributeOverride(name = "productId", column = @Column(name = "product_id")),
            @AttributeOverride(name = "productPrice", column = @Column(name = "product_price")),
            @AttributeOverride(name = "units", column = @Column(name = "units"))
    })
    private final List<InvoiceLinePostgresDto> lines;
}
