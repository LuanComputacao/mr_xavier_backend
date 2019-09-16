package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Knowledge;
import com.luancomputacao.mr_xavier_backend.repositories.KnowledgeRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnowledgeService {

    @Autowired
    KnowledgeRepository knowledgeRepository;

    public List list() {
        Optional<List<Knowledge>> professores = Optional.of(knowledgeRepository.findAll());
        return professores.orElseThrow(() -> new ObjectNotFoundException("Knowledges não encontrados"));
    }

    public Knowledge findById(Integer id){
        Optional<Knowledge> knowledge = knowledgeRepository.findById(id);
        return knowledge.orElseThrow(() -> new ObjectNotFoundException("Knowledge " + id + "não encontrado"));
    }

}
