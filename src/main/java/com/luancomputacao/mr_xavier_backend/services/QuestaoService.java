package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Questao;
import com.luancomputacao.mr_xavier_backend.repositories.QuestaoRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {

    @Autowired
    QuestaoRepository questaoRepository;

    public List list() {
        Optional<List> questoes = Optional.of(questaoRepository.findAll());
        return questoes.orElseThrow(() -> new ObjectNotFoundException("Questoes não encontradas"));
    }

    public Questao findById(Integer id) {
        Optional<Questao> questao = questaoRepository.findById(id);
        return questao.orElseThrow(() -> new ObjectNotFoundException("Questão " + id + " não encontrada"));
    }
}
