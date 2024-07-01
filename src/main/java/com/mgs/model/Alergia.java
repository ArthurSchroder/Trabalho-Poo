package com.mgs.model;

import com.mgs.controller.dto.AlergiaDTO;
import com.mgs.enums.Severidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alergias")
public class Alergia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "descricao", unique = true)
    private String descricao;

    @Column(name = "grau")
    private Severidade grau;

    @OneToMany(mappedBy = "alergias", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuncionarioAlergia> funcionarios;

    public Alergia(AlergiaDTO alergiaDTO){
        this.descricao = alergiaDTO.getDescricao();
        this.grau = alergiaDTO.getGrau();
    }


}
