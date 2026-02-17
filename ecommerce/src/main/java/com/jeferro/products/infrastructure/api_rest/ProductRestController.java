package com.jeferro.products.infrastructure.api_rest;

import com.jeferro.products.application.GetProductUseCase;
import com.jeferro.products.application.ListProductsUseCase;
import com.jeferro.products.infrastructure.api_rest.dtos.ProductRestDto;
import com.jeferro.products.infrastructure.api_rest.mapper.ProductRestMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Path("/v1/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ProductRestController {

    private final ListProductsUseCase listProductsUseCase;
    private final GetProductUseCase getProductUseCase;
    private final ProductRestMapper productRestMapper;

    @GET
    public List<ProductRestDto> findAll() {
        return listProductsUseCase.execute().stream()
                .map(productRestMapper::toRestDto)
                .toList();
    }

    @GET
    @Path("/{id}")
    public ProductRestDto getDetail(@PathParam("id") String id) {
        var product = getProductUseCase.execute(id);

        return productRestMapper.toRestDto(product);
    }
}
