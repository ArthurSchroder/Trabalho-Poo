package com.mgs.services;

import com.mgs.controller.dto.FuncionarioDTO;
import com.mgs.model.Funcionario;
import com.mgs.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> buscarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvarFuncionario(FuncionarioDTO funcionario) {
        Funcionario save = funcionarioRepository.save(new Funcionario(funcionario));
        return save;
    }
}
