package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.ProfessorUtilizaTeste;
import com.luancomputacao.mr_xavier_backend.repositories.ProfessorUtilizaTesteRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorUtilizaTesteService {

    @Autowired
    ProfessorUtilizaTesteRepository professorUtilizaTesteRepository;

    public List list() {
        Optional<List> questoes = Optional.of(professorUtilizaTesteRepository.findAll());
        return questoes.orElseThrow(() -> new ObjectNotFoundException("Questoes não encontradas"));
    }

    public ProfessorUtilizaTeste findById(Integer id) {
        Optional<ProfessorUtilizaTeste> obj = professorUtilizaTesteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Questão " + id + " não encontrada"));
    }

}
