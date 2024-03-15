package com.seletivo.sesp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;
    @Schema(example = "Gustavo", required = true)
    private String nome;
    @Schema(example = "123456", required = true)
    private String rg;
    @Schema(example = "83137913659", required = true)
    private String cpf;
    @Schema(example = "2010-05-12", required = true)
    private LocalDate nascimento;
    @Schema(example = "exemplo@seuemail.com", required = true)
    private String email;
    @Schema(example = "65988782525", required = true)
    private String telefone;
    @Schema(example = "Maria Lemos", required = true)
    private String mae;
    @Schema(example = "JoseLemos", required = true)
    private String pai;
    @Schema(example = "2010-05-12", required = true)
    private LocalDate cadastradoEm;


}

