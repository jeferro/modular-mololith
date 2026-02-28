package com.jeferro.invoices.clients.infrastructure.rest_client.apis;

import com.jeferro.invoices.clients.infrastructure.rest_client.dtos.ClientRestDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "clients-api")
@Path("/v1/clients")
@Produces(MediaType.APPLICATION_JSON)
public interface ClientsRestApi {

  @GET
  @Path("/{id}")
  ClientRestDto getById(@PathParam("id") String id);
}