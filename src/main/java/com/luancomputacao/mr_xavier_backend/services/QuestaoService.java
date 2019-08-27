package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Questao;
import com.luancomputacao.mr_xavier_backend.repositories.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestaoService {

    @Autowired
    QuestaoRepository questaoRepository;

    public Optional<Questao> findById(Integer id) {
        return questaoRepository.findById(id);
    }
}
