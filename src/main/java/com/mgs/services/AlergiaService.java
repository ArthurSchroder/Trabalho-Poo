package com.mgs.services;

import com.mgs.controller.dto.AlergiaDTO;
import com.mgs.model.Alergia;
import com.mgs.model.Funcionario;
import com.mgs.model.FuncionarioAlergia;
import com.mgs.repository.AlergiaRepository;
import com.mgs.repository.FuncionarioAlergiaRepository;
import com.mgs.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlergiaService {
    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioAlergiaRepository funcionarioAlergiaRepository;


    public List<Alergia> buscarTodasAsAlergias() {
        return alergiaRepository.findAll();
    }

    public Alergia salvarAlergia(AlergiaDTO alergiaDTO) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(alergiaDTO.getFuncionarioId());
        if (funcionario.isPresent()){
            Alergia alergia = new Alergia(alergiaDTO);
            Alergia alergiaNova = alergiaRepository.save(alergia);
            FuncionarioAlergia funcionarioAlergia = new FuncionarioAlergia(funcionario.get(), alergiaNova);
            funcionarioAlergiaRepository.save(funcionarioAlergia);
            return alergiaNova;
        }
        return null;
    }
}
