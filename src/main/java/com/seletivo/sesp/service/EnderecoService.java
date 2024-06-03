package com.seletivo.sesp.service;

import com.seletivo.sesp.dto.EnderecoRequest;
import com.seletivo.sesp.dto.EnderecoResponse;
import com.seletivo.sesp.dto.PessoaDTO;
import com.seletivo.sesp.mappers.EnderecoMapper;
import com.seletivo.sesp.mappers.PessoaMapper;
import com.seletivo.sesp.model.Endereco;
import com.seletivo.sesp.model.Pessoa;
import com.seletivo.sesp.repository.EnderecoRepository;
import com.seletivo.sesp.repository.PessoaRepository;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EnderecoService {


    @Inject
    EnderecoMapper enderecoMapper;

    @Inject
    PessoaMapper pessoaMapper;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    PessoaRepository pessoaRepository;


    public List<EnderecoResponse> listarEndereco(int page, int size) {
        List<Endereco> enderecos = enderecoRepository.findAll().page(Page.of(page, size)).list();
        List<EnderecoResponse> enderecoResponses = new ArrayList<>();
        for (Endereco endereco : enderecos) {
            EnderecoResponse enderecoResponse = enderecoMapper.toDTO(endereco);
            enderecoResponses.add(enderecoResponse);
            PessoaDTO pessoaDTO = pessoaMapper.toDTO(endereco.getPessoa());
            enderecoResponse.setPessoa(pessoaDTO);
        }
        return enderecoResponses;

    }

    @Transactional
    public EnderecoResponse salvarEndereco(EnderecoRequest enderecoRequest) {
        Pessoa pessoa = pessoaRepository.findById(enderecoRequest.getPessoaId());
        var endereco = enderecoMapper.toEntity(enderecoRequest);
        endereco.setPessoa(pessoa);
        enderecoRepository.persist(endereco);
        var dto = enderecoMapper.toDTO(endereco);
        var pessoaDTO = pessoaMapper.toDTO(endereco.getPessoa());
        dto.setPessoa(pessoaDTO);
        return dto;
    }


    @Transactional
    public EnderecoResponse atualizarEndereco(Long id, EnderecoRequest enderecoRequest) {
        var endereco = enderecoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Não encontrado"));
        enderecoMapper.update(endereco, enderecoRequest);
        enderecoRepository.persist(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    @Transactional
    public void deletarEndereco(Long id) {
        var endereco = enderecoRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Não encontrado"));
        enderecoRepository.delete(endereco);
    }

}
