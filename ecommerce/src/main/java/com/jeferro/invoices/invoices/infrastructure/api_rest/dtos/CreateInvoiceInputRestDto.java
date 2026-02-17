package com.jeferro.invoices.invoices.infrastructure.api_rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceInputRestDto {

    private String clientId;
    private List<InvoiceLineInputRestDto> lines;
}
