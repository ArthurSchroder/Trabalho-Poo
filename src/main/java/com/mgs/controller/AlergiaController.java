package com.mgs.controller;

import com.mgs.controller.dto.AlergiaDTO;
import com.mgs.model.Alergia;
import com.mgs.model.Funcionario;
import com.mgs.services.AlergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alergias")
public class AlergiaController {
    @Autowired
    AlergiaService alergiaService;

    @GetMapping
    public ResponseEntity<List<Alergia>> buscarAlergias(){
        List<Alergia> alergias = alergiaService.buscarTodasAsAlergias();
       return new ResponseEntity<>(alergias, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Alergia> salvarAlergia(@RequestBody AlergiaDTO alergiaDTO){
        Alergia alergiaNova = alergiaService.salvarAlergia(alergiaDTO);
        if (alergiaNova == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alergiaNova, HttpStatus.OK);
    }
}
