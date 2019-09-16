package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Question;
import com.luancomputacao.mr_xavier_backend.repositories.QuestionRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List list() {
        Optional<List> questions = Optional.of(questionRepository.findAll());
        return questions.orElseThrow(() -> new ObjectNotFoundException("Questions não encontradas"));
    }

    public Question findById(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.orElseThrow(() -> new ObjectNotFoundException("Questão " + id + " não encontrada"));
    }
}
