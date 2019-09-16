package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.ProfessorUtilizaTest;
import com.luancomputacao.mr_xavier_backend.repositories.ProfessorUtilizaTestRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorUtilizaTestService {

    @Autowired
    ProfessorUtilizaTestRepository professorUtilizaTestRepository;

    public List list() {
        Optional<List> questoes = Optional.of(professorUtilizaTestRepository.findAll());
        return questoes.orElseThrow(() -> new ObjectNotFoundException("Questoes não encontradas"));
    }

    public ProfessorUtilizaTest findById(Integer id) {
        Optional<ProfessorUtilizaTest> obj = professorUtilizaTestRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Questão " + id + " não encontrada"));
    }

}
