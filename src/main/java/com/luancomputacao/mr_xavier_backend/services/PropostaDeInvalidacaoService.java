package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.PropostaDeInvalidacao;
import com.luancomputacao.mr_xavier_backend.repositories.PropostaDeInvalidacaoRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropostaDeInvalidacaoService {
    @Autowired
    PropostaDeInvalidacaoRepository propostaDeInvalidacaoRepository;

    public List list() {
        Optional<List> propostaDeInvalidacao = Optional.of(propostaDeInvalidacaoRepository.findAll());
        return propostaDeInvalidacao.orElseThrow(() -> new ObjectNotFoundException("Questions não encontradas"));
    }

    public PropostaDeInvalidacao findById(Integer id) {
        Optional<PropostaDeInvalidacao> propostaDeInvalidacao = propostaDeInvalidacaoRepository.findById(id);
        return propostaDeInvalidacao.orElseThrow(() -> new ObjectNotFoundException("Questão " + id + " não encontrada"));
    }
}
