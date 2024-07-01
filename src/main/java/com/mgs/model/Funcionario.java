package com.mgs.model;

import com.mgs.controller.dto.FuncionarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "data_de_nascimento")
    private Date dataDeNascimento;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuncionarioComorbidades> comorbidades;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuncionarioAlergia> alergias;

    public Funcionario(FuncionarioDTO funcionarioDTO){
        this.nome = funcionarioDTO.getNome();
        this.cpf = funcionarioDTO.getCpf();
        this.email = funcionarioDTO.getEmail();
        this.dataDeNascimento = funcionarioDTO.getDataDeNascimento();
    }

    public Funcionario(Long funcionarioId) {
        this.id = funcionarioId;
    }
}
