package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Disciplina;
import com.luancomputacao.mr_xavier_backend.repositories.DisciplinaRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public Disciplina findById(Integer id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        return disciplina.orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado"));
    }

    public List list() {
        Optional<List> disciplinas = Optional.of(disciplinaRepository.findAll());
        return disciplinas.orElseThrow(() -> new ObjectNotFoundException("Professores não encontrados"));
    }

}
