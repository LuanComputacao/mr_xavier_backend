package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Teste;
import com.luancomputacao.mr_xavier_backend.repositories.TesteRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TesteService {
    @Autowired
    TesteRepository testeRepository;

    public List list() {
        Optional<List> testes = Optional.of(testeRepository.findAll());
        return testes.orElseThrow(() -> new ObjectNotFoundException("Testes não encontrados"));
    }

    public Teste findById(Integer id) {
        Optional<Teste> teste = testeRepository.findById(id);
        return teste.orElseThrow(() -> new ObjectNotFoundException("Teste " + id +" não encontrado"));
    }

}
