package com.seletivo.sesp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logradouro")
    @NotBlank(message = "não pode ser nulo ou vazio")
    private String logradouro;

    @Column(name = "bairro")
    @NotBlank(message = "não pode ser nulo ou vazio")
    private String bairro;

    @Column(name = "numero")
    @NotNull(message = "não pode ser nulo")
    private int numero;

    @Column(name = "cidade")
    @NotBlank(message = "não pode ser nulo ou vazio")
    private String cidade;

    @Column(name = "estado")
    @NotBlank(message = "não pode ser nulo ou vazio")
    private String estado;

    @Column(name = "cep")
    @NotBlank(message = "não pode ser nulo ou vazio")
    private String cep;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
}
