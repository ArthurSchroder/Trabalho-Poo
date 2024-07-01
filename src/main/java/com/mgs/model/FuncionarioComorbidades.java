package com.mgs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FUNCIONARIOXCOMORBIDADES")
@Entity
public class FuncionarioComorbidades {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @ManyToOne
    @JoinColumn(name = "alergia_id")
    private Comorbidade comorbidade;
    public FuncionarioComorbidades(Funcionario funcionario, Comorbidade comorbidade) {
        this.funcionario = funcionario;
        this.comorbidade = comorbidade;
    }

    public FuncionarioComorbidades(Optional<Funcionario> funcionario, Alergia alergia) {
    }

    public FuncionarioComorbidades(Optional<Funcionario> funcionario, Comorbidade comorbidade) {
    }
}
