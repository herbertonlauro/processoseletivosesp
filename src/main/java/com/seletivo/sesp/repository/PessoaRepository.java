package com.seletivo.sesp.repository;


import com.seletivo.sesp.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {

}
