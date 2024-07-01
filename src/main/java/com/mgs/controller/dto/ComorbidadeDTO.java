package com.mgs.controller.dto;

import com.mgs.enums.Severidade;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComorbidadeDTO {
    private Long funcionarioId;

    private String descricao;

    private Severidade grau;
}
