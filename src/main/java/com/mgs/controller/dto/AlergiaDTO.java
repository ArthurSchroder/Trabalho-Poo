package com.mgs.controller.dto;

import com.mgs.enums.Severidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlergiaDTO {
    private Long funcionarioId;
    private String descricao;
    private Severidade grau;
}
