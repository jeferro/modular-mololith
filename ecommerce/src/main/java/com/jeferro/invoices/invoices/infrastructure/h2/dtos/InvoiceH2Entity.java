package com.jeferro.invoices.invoices.infrastructure.h2.dtos;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "invoices_invoices")
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class InvoiceH2Entity {

    @Id
    private final String id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "client_id")),
            @AttributeOverride(name = "name", column = @Column(name = "client_name"))
    })
    private final ClientInfoH2Dto client;

    @Column(name = "created_at", nullable = false)
    private final LocalDate createdAt;

    @Column(name = "issued_at", nullable = false)
    private final LocalDate issuedAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "invoices_invoice_lines",
            joinColumns = @JoinColumn(name = "invoice_id")
    )
    @AttributeOverrides({
            @AttributeOverride(name = "productId", column = @Column(name = "product_id")),
            @AttributeOverride(name = "productPrice", column = @Column(name = "product_price")),
            @AttributeOverride(name = "units", column = @Column(name = "units"))
    })
    private final List<InvoiceLineH2Dto> lines;
}
