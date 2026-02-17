package com.jeferro.invoices.invoices.infrastructure.api_rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRestDto {

    private String id;
    private ClientInfoRestDto client;
    private LocalDate createdAt;
    private LocalDate issuedAt;
    private List<InvoiceLineRestDto> lines;
}
