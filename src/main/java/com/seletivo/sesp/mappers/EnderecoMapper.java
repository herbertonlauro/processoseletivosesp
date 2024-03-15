package com.seletivo.sesp.mappers;

import com.seletivo.sesp.dto.EnderecoRequest;
import com.seletivo.sesp.dto.EnderecoResponse;
import com.seletivo.sesp.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface EnderecoMapper {

    EnderecoResponse toDTO(Endereco endereco);
    Endereco toEntity(EnderecoRequest enderecoRequest);

    void update(@MappingTarget Endereco endereco, EnderecoRequest enderecoRequest);
}
