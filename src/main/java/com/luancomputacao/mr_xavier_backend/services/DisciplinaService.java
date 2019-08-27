package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Disciplina;
import com.luancomputacao.mr_xavier_backend.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public Optional<Disciplina> findById(Integer id) {
        Optional<Disciplina> obj = disciplinaRepository.findById(id);
        return obj;
    }
}
