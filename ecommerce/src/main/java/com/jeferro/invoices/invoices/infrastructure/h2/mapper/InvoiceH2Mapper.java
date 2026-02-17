package com.jeferro.invoices.invoices.infrastructure.h2.mapper;

import com.jeferro.invoices.invoices.domain.models.ClientInfo;
import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.domain.models.InvoiceLine;
import com.jeferro.invoices.invoices.infrastructure.h2.dtos.ClientInfoH2Dto;
import com.jeferro.invoices.invoices.infrastructure.h2.dtos.InvoiceH2Entity;
import com.jeferro.invoices.invoices.infrastructure.h2.dtos.InvoiceLineH2Dto;
import org.mapstruct.Mapper;

@Mapper
public interface InvoiceH2Mapper {

    Invoice toDomain(InvoiceH2Entity entity);

    InvoiceH2Entity toEntity(Invoice domain);

    InvoiceLineH2Dto toDto(InvoiceLine value);

    ClientInfoH2Dto toDto(ClientInfo value);
}
