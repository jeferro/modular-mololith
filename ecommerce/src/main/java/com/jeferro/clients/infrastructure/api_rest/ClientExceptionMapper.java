package com.jeferro.clients.infrastructure.api_rest;

import com.jeferro.clients.domain.exceptions.ClientNotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ClientExceptionMapper implements ExceptionMapper<ClientNotFoundException> {

    @Override
    public Response toResponse(ClientNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponse(exception.getMessage()))
                .build();
    }

    record ErrorResponse(String message) {}
}
