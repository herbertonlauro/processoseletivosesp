package com.seletivo.sesp.mappers;

import com.seletivo.sesp.dto.PessoaDTO;
import com.seletivo.sesp.model.Pessoa;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface PessoaMapper {

    PessoaDTO toDTO(Pessoa pessoa);

    Pessoa toEntity(PessoaDTO pessoaDTO);

    void update(@MappingTarget Pessoa pessoa, PessoaDTO pessoaDTO);
}
