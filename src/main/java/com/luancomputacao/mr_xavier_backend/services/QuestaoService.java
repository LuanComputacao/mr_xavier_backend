package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Question;
import com.luancomputacao.mr_xavier_backend.repositories.QuestaoRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {

    @Autowired
    QuestaoRepository questionRepository;

    public List list() {
        Optional<List> questoes = Optional.of(questionRepository.findAll());
        return questoes.orElseThrow(() -> new ObjectNotFoundException("Questoes não encontradas"));
    }

    public Question findById(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.orElseThrow(() -> new ObjectNotFoundException("Questão " + id + " não encontrada"));
    }
}
