package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.FaseDeEnsino;
import com.luancomputacao.mr_xavier_backend.repositories.FaseDeEnsinoRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaseDeEnsinoService {

    @Autowired
    FaseDeEnsinoRepository faseDeEnsinoRepository;

    public List list() {
        Optional<List> fasesDeEnsino = Optional.of(faseDeEnsinoRepository.findAll());
        return fasesDeEnsino.orElseThrow(() -> new ObjectNotFoundException("Fases de Ensino não encontradasd"));
    }

    public FaseDeEnsino findById(Integer id) {
        Optional<FaseDeEnsino> faseDeEnsino = faseDeEnsinoRepository.findById(id);
        return faseDeEnsino.orElseThrow(() -> new ObjectNotFoundException("Fase de Ensino " + id + " não encontrada"));
    }
}
