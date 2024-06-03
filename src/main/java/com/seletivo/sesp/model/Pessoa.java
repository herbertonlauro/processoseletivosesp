package com.seletivo.sesp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "não pode ser nulo ou vazio")
    @Schema(example = "Gustavo Lemos", required = true)
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "não pode ser nulo ou vazio")
    @Schema(example = "123456", required = true)
    private String rg;

    @CPF
    @NotBlank(message = "não pode ser nulo ou vazio")
    @Schema(example = "90547837887", required = true)
    @Column(unique = true)
    private String cpf;

    @NotNull(message = "não pode ser nulo")
    @Schema(example = "2022-03-10", required = true)
    private LocalDate nascimento;

    @Email(message = "email invalido")
    @NotBlank(message = "não pode ser nulo ou vazio")
    @Schema(example = "seuemail@gmail.com", required = true)
    @Column(unique = true)
    private String email;

    @NotBlank(message = "não pode ser nulo ou vazio")
    @Schema(example = "(83)99565-2978", required = true)
    private String telefone;

    @NotBlank(message = "não pode ser nulo ou vazio")
    @Schema(example = "Elisa Isa", required = true)
    private String mae;

    @NotBlank(message = "não pode ser nulo ou vazio")
    @Schema(example = "Roberto isa", required = true)
    private String pai;

    @NotNull(message = "não pode ser nulo")
    @Schema(example = "2022-03-10", required = true)
    private LocalDate cadastradoEm;

    @JsonManagedReference
    @OneToOne(mappedBy = "pessoa")
    private Endereco endereco;

    @PrePersist
    public void prePersist() {

        cadastradoEm = LocalDate.now();

    }
}
