package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Test;
import com.luancomputacao.mr_xavier_backend.repositories.TestRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public List list() {
        Optional<List> tests = Optional.of(testRepository.findAll());
        return tests.orElseThrow(() -> new ObjectNotFoundException("Tests não encontrados"));
    }

    public Test findById(Integer id) {
        Optional<Test> test = testRepository.findById(id);
        return test.orElseThrow(() -> new ObjectNotFoundException("Test " + id +" não encontrado"));
    }

}
