package com.seletivo.sesp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {

    private Long id;

    @Schema(example = "Rua faria Lima", required = true)
    private String logradouro;
    @Schema(example = "Bairro do limão", required = true)
    private String bairro;
    @Schema(example = "2557", required = true)
    private int numero;
    @Schema(example = "São Paulo", required = true)
    private String cidade;
    @Schema(example = "SP", required = true)
    private String estado;
    @Schema(example = "78020800", required = true)
    private String cep;

    private PessoaDTO pessoa;
}
