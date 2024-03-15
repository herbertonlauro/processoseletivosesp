package com.seletivo.sesp.repository;


import com.seletivo.sesp.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {

    public List<Pessoa> buscarPessoasPorNome(String nome) {
        return find("upper(nome) like ?1", "%"+nome.toUpperCase()+"%").list();
    }

    public List<Pessoa> filtrarNomeMaeNascimento(String nome, String mae, LocalDate nascimento) {
        StringBuilder query = new StringBuilder("WHERE 1=1");
        Parameters params = new Parameters();
        if (nome != null && !nome.isEmpty()) {
            query.append(" OR upper(nome) like concat('%', upper(:nome), '%')");
            params.and("nome", nome);
        }
        if (mae != null && !mae.isEmpty()) {
            query.append(" OR upper(mae) like concat('%', upper(:mae), '%')");
            params.and("mae", mae);
        }
        if (nascimento != null) {
            query.append(" OR nascimento = :nascimento");
            params.and("nascimento", nascimento);
        }
        return find(query.toString(), params).list();
    }

    public Pessoa buscaPorCpf(String cpf){
        return find("cpf", cpf).firstResult();
    }
    public List<Pessoa> consultarPorCidadeEstado(String cidade, String estado) {
        return find("upper(endereco.cidade) like ?1 AND upper(endereco.estado) like ?2",
                "%"+cidade.toUpperCase()+"%","%"+estado.toUpperCase()+"%").list();

    }
}
