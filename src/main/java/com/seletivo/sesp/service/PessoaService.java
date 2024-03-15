package com.seletivo.sesp.service;

import com.seletivo.sesp.dto.PessoaDTO;
import com.seletivo.sesp.mappers.PessoaMapper;
import com.seletivo.sesp.model.Pessoa;
import com.seletivo.sesp.repository.PessoaRepository;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PessoaService {


    @Inject
    PessoaMapper pessoaMapper;

    @Inject
    PessoaRepository pessoaRepository;


    public List<PessoaDTO> listarTodasPessoas(int page, int size) {
        List<Pessoa> pessoas = pessoaRepository.findAll().page(Page.of(page, size)).list();
        List<PessoaDTO> pessoaDTOS = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);
            pessoaDTOS.add(pessoaDTO);
        }
        return pessoaDTOS;
    }

    @Transactional
    public PessoaDTO salvarPessoa(PessoaDTO pessoaDTO) {
        var pessoa = pessoaMapper.toEntity(pessoaDTO);
        pessoaRepository.persist(pessoa);
        return pessoaMapper.toDTO(pessoa);
    }

    @Transactional
    public PessoaDTO atualizarPessoa(Long id, PessoaDTO pessoaDTO) {
        var pessoa = pessoaRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Não encontrado"));
        pessoaMapper.update(pessoa, pessoaDTO);
        pessoaRepository.persist(pessoa);
        return pessoaMapper.toDTO(pessoa);
    }


    @Transactional
    public void deletarPessoa(Long id) {
        var pessoa = pessoaRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Não encontrado"));
        pessoaRepository.delete(pessoa);
    }


    public List<Pessoa> buscarPessoasPorNome(String nome) {
        return pessoaRepository.buscarPessoasPorNome(nome);
    }

    public Pessoa buscaPorCpf(String cpf) {
        return pessoaRepository.buscaPorCpf(cpf);
    }

    public List<PessoaDTO> consultarPorCidadeEstado(String cidade, String estado) {
        var pessoas = pessoaRepository.consultarPorCidadeEstado(cidade, estado);
        return criarListaDTO(pessoas);
    }

    public List<PessoaDTO> filtrarNomeMaeNascimento(String nome, String mae, LocalDate nascimento) {
        var pessoas = pessoaRepository.filtrarNomeMaeNascimento(nome, mae, nascimento);
        return criarListaDTO(pessoas);
    }

    private List<PessoaDTO> criarListaDTO(List<Pessoa> pessoas) {
        ArrayList<PessoaDTO> pessoasDTOS = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            var dto = pessoaMapper.toDTO(pessoa);
            pessoasDTOS.add(dto);
        }
        return pessoasDTOS;
    }
}
