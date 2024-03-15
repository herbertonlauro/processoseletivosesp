package com.seletivo.sesp.controllers;

import com.seletivo.sesp.dto.EnderecoRequest;
import com.seletivo.sesp.dto.EnderecoResponse;
import com.seletivo.sesp.service.EnderecoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/endereco")
@Tag(name = "Endereço")
public class EnderecoController {


    @Inject
    EnderecoService enderecoService;

    @GET
    public List<EnderecoResponse> listar(@QueryParam("page") @DefaultValue("0") int page,
                                         @QueryParam("size") @DefaultValue("10") int size) {
        return enderecoService.listarEndereco(page, size);
    }


    @POST
    public Response criar(@RequestBody EnderecoRequest enderecoRequest) {
        var endereco = enderecoService.salvarEndereco(enderecoRequest);
        return Response.created(URI.create("/endereco")).entity(endereco).build();
    }

    @PUT
    @Path("/{id}")
    public EnderecoResponse atualizar(@PathParam("id") Long id, @RequestBody EnderecoRequest enderecoRequest) {
        return enderecoService.atualizarEndereco(id, enderecoRequest);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(Long id) {
        enderecoService.deletarEndereco(id);
    }

}
