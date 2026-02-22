package com.jeferro.invoices.invoices.infrastructure.postgres.mapper;

import com.jeferro.invoices.invoices.domain.models.ClientInfo;
import com.jeferro.invoices.invoices.domain.models.Invoice;
import com.jeferro.invoices.invoices.domain.models.InvoiceLine;
import com.jeferro.invoices.invoices.infrastructure.postgres.dtos.ClientInfoPostgresDto;
import com.jeferro.invoices.invoices.infrastructure.postgres.dtos.InvoiceLinePostgresDto;
import com.jeferro.invoices.invoices.infrastructure.postgres.dtos.InvoicePostgresEntity;
import org.mapstruct.Mapper;

@Mapper
public interface InvoicePostgresMapper {

    Invoice toDomain(InvoicePostgresEntity entity);

    InvoicePostgresEntity toEntity(Invoice domain);

    InvoiceLinePostgresDto toDto(InvoiceLine value);

    ClientInfoPostgresDto toDto(ClientInfo value);
}
