package com.mgs.model;

import com.mgs.controller.dto.ComorbidadeDTO;
import com.mgs.enums.Severidade;
import jakarta.persistence.*;

import java.security.PublicKey;
import java.util.List;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comorbidade")
public class Comorbidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "grau")
    private Severidade grau;

    @OneToMany(mappedBy = "comorbidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuncionarioComorbidades> funcionario;

    public Comorbidade(ComorbidadeDTO comorbidadeDTO){
        this.descricao = comorbidadeDTO.getDescricao();
        this.grau = comorbidadeDTO.getGrau();
    }
}
