package com.mgs.controller;

import com.mgs.controller.dto.FuncionarioDTO;
import com.mgs.model.Funcionario;
import com.mgs.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> buscarTodosFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.buscarTodosFuncionarios();
        if (funcionarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody FuncionarioDTO funcionario){
        Funcionario funcionarioNovo = funcionarioService.salvarFuncionario(funcionario);
        return new ResponseEntity<>(funcionarioNovo, HttpStatus.OK);
    }
}
