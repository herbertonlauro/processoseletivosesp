package com.seletivo.sesp.controllers;

import com.seletivo.sesp.dto.PessoaDTO;
import com.seletivo.sesp.model.Pessoa;
import com.seletivo.sesp.service.PessoaService;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pessoa")
@Tag(name = "Pessoa")
public class PessoaController {


    @Inject
    PessoaService pessoaService;

    @GET
    public List<PessoaDTO> listar(@QueryParam("page") @DefaultValue("0") int page,
                                  @QueryParam("size") @DefaultValue("10") int size) {
        return pessoaService.listarTodasPessoas(page, size);
    }


    @POST
    public Response criar(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO pesssoa = pessoaService.salvarPessoa(pessoaDTO);
        return Response.created(URI.create("/pessoa")).entity(pesssoa).build();
    }

    @PUT
    @Path("/{id}")
    public PessoaDTO atualizar(@PathParam("id") Long id, @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.atualizarPessoa(id, pessoaDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(Long id) {
        pessoaService.deletarPessoa(id);
    }


    @GET
    @Path("/nome")
    public List<Pessoa> listarpornome(@QueryParam("nome") @NotBlank String nome) {
        return pessoaService.buscarPessoasPorNome(nome);
    }

    @GET
    @Path("/cpf")
    public Response buscarCpf(@QueryParam("cpf")@NotBlank String cpf) {
        var pessoa = pessoaService.buscaPorCpf(cpf);
        if (pessoa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pessoa).build();
    }

    @GET
    @Path("/nome-mae-nascimento")
    public List<PessoaDTO> filtrarNomeMaeNascimento(@QueryParam("nome") @DefaultValue("") String nome,
                                                    @QueryParam("mae") @DefaultValue("") String mae,
                                                    @QueryParam("nascimento") LocalDate nascimento) {
        return pessoaService.filtrarNomeMaeNascimento(nome, mae, nascimento);
    }
    @GET
    @Path("/porCidadeEstado")
    public List<PessoaDTO> consultarPorCidadeEstado(
            @QueryParam("cidade")@NotBlank String cidade,
            @QueryParam("estado")@NotBlank String estado) {
        return pessoaService.consultarPorCidadeEstado(cidade, estado);
    }
}
