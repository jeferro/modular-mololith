package com.jeferro.invoices.invoices.infrastructure.api_rest;

import com.jeferro.invoices.invoices.domain.exceptions.InvoiceNotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InvoiceExceptionMapper implements ExceptionMapper<InvoiceNotFoundException> {

    @Override
    public Response toResponse(InvoiceNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponse(exception.getMessage()))
                .build();
    }

    record ErrorResponse(String message) {}
}
