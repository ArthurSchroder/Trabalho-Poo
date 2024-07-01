package com.mgs.controller;

import com.mgs.controller.dto.AlergiaDTO;
import com.mgs.controller.dto.ComorbidadeDTO;
import com.mgs.model.Alergia;
import com.mgs.model.Comorbidade;
import com.mgs.services.ComorbidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comorbidade")
public class ComorbidadeController {

    @Autowired
    ComorbidadeService comorbidadeService;

    @GetMapping
    public ResponseEntity<List<Comorbidade>> buscarTodasComorbidades(){
        List<Comorbidade> comorbidades= comorbidadeService.buscarTodasComorbidades();
        return new ResponseEntity<>(comorbidades, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comorbidade> salvarComorbidade(@RequestBody ComorbidadeDTO comorbidadeDTO){
        Comorbidade comorbidadeNova = comorbidadeService.salvarComorbidade(comorbidadeDTO);
        if (comorbidadeNova == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(comorbidadeNova, HttpStatus.OK);
    }
}
