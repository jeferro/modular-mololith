package com.jeferro.invoices.invoices.infrastructure.api_rest.mapper;

import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.infrastructure.api_rest.dtos.InvoiceRestDto;
import org.mapstruct.Mapper;

@Mapper
public interface InvoiceRestMapper {

    InvoiceRestDto toRestDto(Invoice domain);

    Invoice toDomain(InvoiceRestDto dto);
}
