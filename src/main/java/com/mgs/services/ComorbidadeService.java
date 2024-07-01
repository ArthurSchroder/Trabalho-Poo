package com.mgs.services;

import com.mgs.controller.dto.ComorbidadeDTO;
import com.mgs.model.*;
import com.mgs.repository.ComorbidadeRepository;
import com.mgs.repository.FuncionarioComorbidadesRepository;
import com.mgs.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComorbidadeService {
    @Autowired
    ComorbidadeRepository comorbidadeRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FuncionarioComorbidadesRepository funcionarioComorbidadesRepository;

    public List<Comorbidade> buscarTodasComorbidades() {
        return comorbidadeRepository.findAll();
    }

    public Comorbidade salvarComorbidade(ComorbidadeDTO comorbidadeDTO) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(comorbidadeDTO.getFuncionarioId());
        if (funcionario.isPresent()){
            Comorbidade comorbidade = new Comorbidade(comorbidadeDTO);
            FuncionarioComorbidades funcionarioComorbidades = new FuncionarioComorbidades(funcionario, comorbidade);
            funcionarioComorbidadesRepository.save(funcionarioComorbidades);
            return comorbidadeRepository.save(comorbidade);
        }
        return null;
    }
}
