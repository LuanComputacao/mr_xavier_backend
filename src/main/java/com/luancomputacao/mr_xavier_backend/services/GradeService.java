package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Grade;
import com.luancomputacao.mr_xavier_backend.repositories.GradeRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    public List list() {
        Optional<List> grades = Optional.of(gradeRepository.findAll());
        return grades.orElseThrow(() -> new ObjectNotFoundException("Fases de Ensino não encontradasd"));
    }

    public Grade findById(Integer id) {
        Optional<Grade> grade = gradeRepository.findById(id);
        return grade.orElseThrow(() -> new ObjectNotFoundException("Fase de Ensino " + id + " não encontrada"));
    }
}
