package com.jeferro.invoices.invoices.infrastructure.api_rest;

import com.jeferro.invoices.invoices.application.CreateInvoiceUseCase;
import com.jeferro.invoices.invoices.application.GetInvoiceUseCase;
import com.jeferro.invoices.invoices.application.ListInvoicesUseCase;
import com.jeferro.invoices.invoices.domain.models.InvoiceLineInput;
import com.jeferro.invoices.invoices.infrastructure.api_rest.dtos.CreateInvoiceInputRestDto;
import com.jeferro.invoices.invoices.infrastructure.api_rest.dtos.InvoiceLineInputRestDto;
import com.jeferro.invoices.invoices.infrastructure.api_rest.dtos.InvoiceRestDto;
import com.jeferro.invoices.invoices.infrastructure.api_rest.mapper.InvoiceRestMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@Path("/v1/invoices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class InvoiceRestController {

    private final ListInvoicesUseCase listInvoicesUseCase;
    private final GetInvoiceUseCase getInvoiceUseCase;
    private final CreateInvoiceUseCase createInvoiceUseCase;
    private final InvoiceRestMapper invoiceRestMapper;

    @POST
    public Response create(CreateInvoiceInputRestDto input) {
        var clientId = input.getClientId();
        var linesInput = Objects.requireNonNullElse(input.getLines(), List.<InvoiceLineInputRestDto>of()).stream()
                .map(line -> new InvoiceLineInput(
                        line.getProductId(),
                        line.getUnits()
                ))
                .toList();

        var invoice = createInvoiceUseCase.execute(clientId, linesInput);

        return Response.status(Response.Status.CREATED)
                .entity(invoiceRestMapper.toRestDto(invoice))
                .build();
    }

    @GET
    public List<InvoiceRestDto> findAll() {
        return listInvoicesUseCase.execute().stream()
                .map(invoiceRestMapper::toRestDto)
                .toList();
    }

    @GET
    @Path("/{id}")
    public InvoiceRestDto getDetail(@PathParam("id") String id) {
        var invoice = getInvoiceUseCase.execute(id);

        return invoiceRestMapper.toRestDto(invoice);
    }
}
