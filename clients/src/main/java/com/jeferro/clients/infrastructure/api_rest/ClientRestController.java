package com.jeferro.clients.infrastructure.api_rest;

import com.jeferro.clients.application.GetClientUseCase;
import com.jeferro.clients.application.ListClientsUseCase;
import com.jeferro.clients.infrastructure.api_rest.dtos.ClientRestDto;
import com.jeferro.clients.infrastructure.api_rest.mapper.ClientRestMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Path("/v1/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ClientRestController {

    private final ListClientsUseCase listClientsUseCase;
    private final GetClientUseCase getClientUseCase;
    private final ClientRestMapper clientRestMapper;

    @GET
    public List<ClientRestDto> findAll() {
        return listClientsUseCase.execute().stream()
                .map(clientRestMapper::toRestDto)
                .toList();
    }

    @GET
    @Path("/{id}")
    public ClientRestDto getDetail(@PathParam("id") String id) {
        var client = getClientUseCase.execute(id);
        return clientRestMapper.toRestDto(client);
    }
}
