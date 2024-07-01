package com.mgs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FUNCIONARIOXALERGIA")
@Entity
public class FuncionarioAlergia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @ManyToOne
    @JoinColumn(name = "alergia_id")
    private Alergia alergias;
    public FuncionarioAlergia(Funcionario funcionario, Alergia alergia) {
        this.funcionario = funcionario;
        this.alergias = alergia;
    }

}
