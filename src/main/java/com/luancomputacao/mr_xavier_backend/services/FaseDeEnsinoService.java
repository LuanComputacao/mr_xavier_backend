package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.FaseDeEnsino;
import com.luancomputacao.mr_xavier_backend.repositories.FaseDeEnsinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FaseDeEnsinoService {

    @Autowired
    FaseDeEnsinoRepository faseDeEnsinoRepository;

    public Optional<FaseDeEnsino> findById(Integer id) {
        return faseDeEnsinoRepository.findById(id);
    }
}
